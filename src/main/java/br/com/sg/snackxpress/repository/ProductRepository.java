package br.com.sg.snackxpress.repository;

import br.com.sg.snackxpress.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
