package br.com.sg.snackxpress.repository;

import br.com.sg.snackxpress.domain.product.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    Optional<Recipe> findByProductFinalId(Long id);
}
