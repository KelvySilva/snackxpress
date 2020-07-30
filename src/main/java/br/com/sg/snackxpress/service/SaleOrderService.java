package br.com.sg.snackxpress.service;

import br.com.sg.snackxpress.builder.ClientBuilder;
import br.com.sg.snackxpress.domain.order.SaleOrder;
import br.com.sg.snackxpress.domain.order.SaleOrderItem;
import br.com.sg.snackxpress.domain.person.Client;
import br.com.sg.snackxpress.domain.product.Recipe;
import br.com.sg.snackxpress.error.ResourceNotFoundException;
import br.com.sg.snackxpress.repository.ClientRepository;
import br.com.sg.snackxpress.repository.ProductFinalRepository;
import br.com.sg.snackxpress.repository.RecipeRepository;
import br.com.sg.snackxpress.repository.SaleOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SaleOrderService {

    private SaleOrderRepository repository;

    private ClientRepository clientRepository;

    private RecipeRepository recipeRepository;

    private ProductFinalRepository productRepository;

    @Autowired
    public SaleOrderService(
            SaleOrderRepository repository,
            ClientRepository clientRepository,
            RecipeRepository recipeRepository,
            ProductFinalRepository productRepository
    ) {
        this.repository = repository;
        this.clientRepository = clientRepository;
        this.recipeRepository = recipeRepository;
        this.productRepository = productRepository;
    }


    public List<SaleOrder> listAll() {
        List<SaleOrder> all = this.repository.findAll();
        if (all.isEmpty()) {
            throw new ResourceNotFoundException("Nenhum pedido realizado");
        }
        return all;
    }

    public SaleOrder findOne(Long id) {
        return this.repository.findById(id)
                .orElseThrow(() ->
                            new ResourceNotFoundException(String.format("Pedido id: %s não encontrado", id))
                );
    }

    @Transactional
    public SaleOrder saveOne(SaleOrder saleOrder) {
        if (
                Objects.nonNull(saleOrder.getClient()) &&
                Objects.nonNull(saleOrder.getClient().getId())
        ) {
            Client clientExistent = this.clientRepository.findById(saleOrder.getClient().getId())
                    .orElseThrow(() -> new ResourceNotFoundException(
                            String.format("Cliente com id %s não encontrado!", saleOrder.getClient().getId())
                    ));

            saleOrder.setClient(clientExistent);
            saleOrder.setItemList(resolveList(saleOrder.getItemList()));
            SaleOrder updatable = resolveOrder(saleOrder);

            return this.repository.save(updatable);
        }
        if (Objects.isNull(saleOrder.getClient()) || Objects.isNull(saleOrder.getClient().getId())  || Objects.isNull(saleOrder.getClient().getCpf()) ) {
            Client build = ClientBuilder.aClient().build();
            saleOrder.setClient(build);
            saleOrder.setItemList(resolveList(saleOrder.getItemList()));
            SaleOrder updatable = resolveOrder(saleOrder);
            return this.repository.save(updatable);
        }else {
            throw new ResourceNotFoundException("Não foi possível Realizar a operação!");
        }


    }

    private List<SaleOrderItem> resolveList(List<SaleOrderItem> list) {
        list.stream()
                .forEach(item -> {
                    item.setSubtotal(
                            item.getProducts()
                                    .stream()
                                    .map(prod -> prod.getPrice()).reduce(BigDecimal.ZERO , BigDecimal::add)
                    );
                    item.setDiscount(
                            item.getProducts()
                                    .stream()
                                    .map(prod -> prod.getDiscount()).reduce(BigDecimal.ZERO, BigDecimal::add)
                    );
                    item.getProducts()
                            .stream()
                            .forEach(prod ->{
                                Optional<Recipe> recipeOptional = this.recipeRepository.findByProductFinalId(prod.getId());
                                if (recipeOptional.isPresent()) {
                                    Recipe recipe = recipeOptional.get();
                                    recipe.getComposities()
                                            .stream()
                                            .forEach(comp -> {
                                                comp.getIngredient()
                                                        .getStock()
                                                        .setQuantity(comp.getIngredient().getStock().getQuantity() - 1);
                                            });
                                    this.recipeRepository.saveAndFlush(recipe);
                                }else {
                                    prod.getStock()
                                            .setQuantity(prod.getStock().getQuantity() -1);
                                    this.productRepository.saveAndFlush(prod);
                                }

                            });
                    item.setTotal(item.getSubtotal().subtract(item.getDiscount()));
                });


        return list;
    }

    private SaleOrder resolveOrder(SaleOrder saleOrder) {
        saleOrder.setDiscountAmount(saleOrder.getItemList()
                .stream()
                .map(item -> item.getDiscount())
                .reduce(BigDecimal.ZERO, BigDecimal::add));
        saleOrder.setSubtotal(saleOrder.getItemList()
                .stream()
                .map(item -> item.getSubtotal())
                .reduce(BigDecimal.ZERO, BigDecimal::add));
        saleOrder.setTotal(saleOrder.getItemList()
                .stream()
                .map(item -> item.getTotal())
                .reduce(BigDecimal.ZERO,BigDecimal::add));
        return saleOrder;
    }
}
