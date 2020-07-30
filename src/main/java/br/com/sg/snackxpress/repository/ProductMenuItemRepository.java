package br.com.sg.snackxpress.repository;

import br.com.sg.snackxpress.domain.menu.ProductMenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductMenuItemRepository extends JpaRepository<ProductMenuItem, Long> {
}
