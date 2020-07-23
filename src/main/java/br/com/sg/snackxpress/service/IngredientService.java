package br.com.sg.snackxpress.service;

import br.com.sg.snackxpress.domain.Ingredient;
import br.com.sg.snackxpress.error.ResourceNotFoundException;
import br.com.sg.snackxpress.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class IngredientService {

    private IngredientRepository repository;

    @Autowired
    public IngredientService(IngredientRepository repository) {
        this.repository = repository;
    }

    public List<Ingredient> listall() {
        return this.repository.findAll();
    }

    public Ingredient findOne(Long id) {
        Optional<Ingredient> optionalIngredient = this.repository.findById(id);        
        return optionalIngredient.orElseThrow(
                () -> new ResourceNotFoundException(String.format("O ingrediente codigo %s não existe.", id)));
    }

    @Transactional
    public Ingredient saveOne(Ingredient ingredient) {
        return this.repository.save(ingredient);
    }

    public Ingredient updateOne(Long id, Ingredient ingredient) {
        Optional<Ingredient> optionalIngredient = this.repository.findById(id);
        if (optionalIngredient.isPresent()){

            Ingredient update = optionalIngredient.get();
            
            if (Objects.nonNull(ingredient.getStock()) && !(update.getStock().equals(ingredient.getStock()))) {
                update.setStock(ingredient.getStock());
            }
            if (Objects.nonNull(ingredient.getName()) && !(update.getName().equals(ingredient.getName()))) {
                update.setName(ingredient.getName());
            }

        }
        return null;
    }
}
