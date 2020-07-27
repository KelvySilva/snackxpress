package br.com.sg.snackxpress.service;

import br.com.sg.snackxpress.domain.product.Stock;
import br.com.sg.snackxpress.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    private StockRepository repository;

    @Autowired
    public StockService(StockRepository repository) {
        this.repository = repository;
    }

    public List<Stock> listAll() {
        return this.repository.findAll();
    }

}
