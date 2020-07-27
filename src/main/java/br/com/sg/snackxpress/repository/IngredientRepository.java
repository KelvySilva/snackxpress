package br.com.sg.snackxpress.repository;

import br.com.sg.snackxpress.domain.product.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
