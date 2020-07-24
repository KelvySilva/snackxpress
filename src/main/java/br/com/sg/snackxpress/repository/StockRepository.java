package br.com.sg.snackxpress.repository;

import br.com.sg.snackxpress.domain.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {


}
