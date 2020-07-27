package br.com.sg.snackxpress.repository;

import br.com.sg.snackxpress.domain.product.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
