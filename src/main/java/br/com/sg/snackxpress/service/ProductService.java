package br.com.sg.snackxpress.service;

import br.com.sg.snackxpress.domain.*;
import br.com.sg.snackxpress.error.ResourceNotFoundDetails;
import br.com.sg.snackxpress.error.ResourceNotFoundException;
import br.com.sg.snackxpress.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<AbstractProduct> listAll(){
        return this.repository.findAll();
    }

    public AbstractProduct listOne(Long id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Produto com id %s não encontrado",id)));
    }

    @Transactional
    public ProductComp saveOneComp(ProductComp product) {
        return this.repository.save(product);
    }

    @Transactional
    public ProductBox saveOneBox(ProductBox product) {
        return this.repository.save(product);
    }

    @Transactional
    public ProductInd saveOneInd(ProductInd product) {
        return this.repository.save(product);
    }


}
