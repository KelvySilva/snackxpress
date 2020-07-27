package br.com.sg.snackxpress.service;

import br.com.sg.snackxpress.domain.product.ProductFinal;
import br.com.sg.snackxpress.error.ResourceNotFoundException;
import br.com.sg.snackxpress.repository.ProductFinalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductFinalService {

    private ProductFinalRepository repository;

    @Autowired
    public ProductFinalService(ProductFinalRepository repository) {
        this.repository = repository;
    }

    public List<ProductFinal> listAll(){
        return this.repository.findAll();
    }

    public ProductFinal listOne(Long id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Produto com id %s não encontrado",id)));
    }

    @Transactional
    public ProductFinal saveOne(ProductFinal product) {
        return this.repository.save(product);
    }


    public ProductFinal updateOne(Long id, ProductFinal productFinal) {
        Optional<ProductFinal> productOptional = this.repository.findById(id);
        if (!productOptional.isPresent()){
            throw new ResourceNotFoundException(String.format("O ingrediente codigo %s não existe.", id));
        }
        ProductFinal update = productOptional.get();

        update.setId(id);

        if (Objects.nonNull(productFinal.getName()) && !(update.getName().equals(productFinal.getName()))) {
            update.setName(productFinal.getName());
        }
        if (Objects.nonNull(productFinal.getDescription()) && !(update.getDescription().equals(productFinal.getDescription()))) {
            update.setDescription(productFinal.getDescription());
        }
        if (Objects.nonNull(productFinal.getCost()) && !(update.getCost().equals(productFinal.getCost()))) {
            update.setCost(productFinal.getCost());
        }
        if (Objects.nonNull(productFinal.getType()) && !(update.getType().equals(productFinal.getType()))) {
            update.setType(productFinal.getType());
        }
        if (Objects.nonNull(productFinal.getStock()) && !(update.getStock().equals(productFinal.getStock()))) {
            update.setStock(productFinal.getStock());
        }
        if (
                Objects.nonNull(productFinal.getStock()) &&
                !(update.getStock().equals(productFinal.getStock())) &&
                Objects.nonNull(productFinal.getStock().getId()) &&
                update.getStock().getClass().equals(productFinal.getStock().getId())
        ) {
            update.setStock(productFinal.getStock());
        }
        return this.repository.saveAndFlush(update);
    }
}
