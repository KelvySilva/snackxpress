package br.com.sg.snackxpress.service;

import br.com.sg.snackxpress.domain.menu.ProductMenuItem;
import br.com.sg.snackxpress.domain.product.ProductFinal;
import br.com.sg.snackxpress.error.ResourceNotFoundException;
import br.com.sg.snackxpress.repository.ProductMenuItemRepository;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Service
public class ProductMenuItemService {

    private ProductMenuItemRepository repository;

    @Autowired
    public ProductMenuItemService(ProductMenuItemRepository repository) {
        this.repository = repository;
    }

    public List<ProductMenuItem> listAll() {
        List<ProductMenuItem> all = this.repository.findAll();
        if (all.isEmpty()) {
            throw new ResourceNotFoundException("Nenhum item cadastrado");
        }
        return all;
    }

    public ProductMenuItem findOne(Long id) {
        return this.repository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException(String.format("Item com ID: %s não encontrado!", id))
                );
    }

    @Transactional
    public ProductMenuItem saveOne(ProductMenuItem item) {
        ProductMenuItem productMenuItem = this.resolveItem(item);
        return this.repository.save(productMenuItem);
    }

    @Transactional
    public ProductMenuItem updateOne(Long id, ProductMenuItem item) {
        ProductMenuItem update = this.repository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException(String.format("Item com ID: %s não encontrado!", id))
                );
                if (Objects.nonNull(item) && Objects.nonNull(item.getId())){
                    ProductMenuItem productMenuItem = this.resolveItem(item);
                    update.setDiscountAmount(productMenuItem.getDiscountAmount());
                    update.setTotal(productMenuItem.getTotal());
                    update.setCategory(item.getCategory());
                    update.setSubtotal(productMenuItem.getSubtotal());
                    update.setList(productMenuItem.getList());
                }
        return this.repository.saveAndFlush(update);
    }

    private ProductMenuItem resolveItem(ProductMenuItem item) {

        item.setSubtotal(item.getList().stream()
                .map(prod -> prod.getPrice())
                .reduce(BigDecimal.ZERO, BigDecimal::add));
        item.setDiscountAmount(item.getDiscountAmount().add(
                item.getList()
                .stream()
                .map(prod -> prod.getDiscount())
                .reduce(BigDecimal.ZERO, BigDecimal::add)
        ));

        item.setTotal(item.getTotal().add(item.getSubtotal().subtract(item.getDiscountAmount())));

        return item;
    }
}
