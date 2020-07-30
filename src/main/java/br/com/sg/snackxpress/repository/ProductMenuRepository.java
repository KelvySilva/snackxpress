package br.com.sg.snackxpress.repository;

import br.com.sg.snackxpress.domain.menu.ProductMenu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductMenuRepository extends JpaRepository<ProductMenu, Long> {
}
