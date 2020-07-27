package br.com.sg.snackxpress.service;

import br.com.sg.snackxpress.domain.product.Composite;
import br.com.sg.snackxpress.error.ResourceNotFoundException;
import br.com.sg.snackxpress.repository.CompositeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompositeService {

    private CompositeRepository repository;

    @Autowired
    public CompositeService(CompositeRepository repository) {
        this.repository = repository;
    }

    public List<Composite> listAll() {
        List<Composite> all = this.repository.findAll();
        if (all.isEmpty()) {
            throw new ResourceNotFoundException("Nenhum componente foi cadastrado");
        }
        return all;
    }
}
