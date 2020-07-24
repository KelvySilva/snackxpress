package br.com.sg.snackxpress.service;

import br.com.sg.snackxpress.domain.*;
import br.com.sg.snackxpress.error.ResourceNotFoundException;
import br.com.sg.snackxpress.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductService {

    private ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> listAll(){
        return this.repository.findAll();
    }

    public Product listOne(Long id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Produto com id %s não encontrado",id)));
    }

    @Transactional
    public Product saveOneComp(Product product) {
        return this.repository.save(product);
    }



}
