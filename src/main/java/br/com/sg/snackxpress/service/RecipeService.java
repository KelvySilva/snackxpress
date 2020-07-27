package br.com.sg.snackxpress.service;

import br.com.sg.snackxpress.domain.product.Recipe;
import br.com.sg.snackxpress.error.ResourceNotFoundException;
import br.com.sg.snackxpress.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RecipeService {

    private RecipeRepository repository;

    @Autowired
    public RecipeService(RecipeRepository repository) {
        this.repository = repository;
    }

    public List<Recipe> findAll() {
        List<Recipe> all = this.repository.findAll();
        if (all.isEmpty()) {
            throw new ResourceNotFoundException("Nenhuma receita foi cadastrada");
        }
        return all;
    }

    public Recipe findOne(Long id) {
        return this.repository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException(String.format("A receita com id %s não existe", id))
                );
    }

    @Transactional
    public Recipe saveOne(Recipe recipe) {
        return this.repository.save(recipe);
    }
}
