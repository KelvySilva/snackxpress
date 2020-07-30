package br.com.sg.snackxpress.service;

import br.com.sg.snackxpress.domain.menu.ProductMenu;
import br.com.sg.snackxpress.error.ResourceNotFoundException;
import br.com.sg.snackxpress.repository.ProductMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class ProductMenuService {

    private ProductMenuRepository repository;

    @Autowired
    public ProductMenuService(ProductMenuRepository repository) {
        this.repository = repository;
    }

    public List<ProductMenu> listAll() {
        List<ProductMenu> all = this.repository.findAll();
        if (all.isEmpty()){
            throw new ResourceNotFoundException("Nenhum menu cadastrado");
        }
        return all;
    }

    public ProductMenu findOne(Long id) {
        return this.repository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException(String.format("Menu com ID: %s não encontrado!", id))
                );
    }

    @Transactional
    public ProductMenu saveOne(ProductMenu menu) {
        return this.repository.save(menu);
    }


    @Transactional
    public ProductMenu updateOne(Long id, ProductMenu menu) {
        ProductMenu productMenu = this.repository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException(String.format("Menu com ID: %s não encontrado!", id))
                );
        if (Objects.nonNull(menu) && !(productMenu.getName().equals(menu.getName()))){
            productMenu.setName(menu.getName());
        }
        return this.repository.saveAndFlush(productMenu);

    }
}
