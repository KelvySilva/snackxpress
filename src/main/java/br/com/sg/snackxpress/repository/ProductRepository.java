package br.com.sg.snackxpress.repository;

import br.com.sg.snackxpress.domain.AbstractProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<AbstractProduct, Long> {
}
