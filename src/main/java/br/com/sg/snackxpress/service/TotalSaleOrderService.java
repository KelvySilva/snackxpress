package br.com.sg.snackxpress.service;


import br.com.sg.snackxpress.domain.order.SaleOrder;
import br.com.sg.snackxpress.domain.order.TotalSaleOrder;
import br.com.sg.snackxpress.repository.TotalSaleOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TotalSaleOrderService {

    private TotalSaleOrderRepository repository;

    @Autowired
    public TotalSaleOrderService(TotalSaleOrderRepository repository) {
        this.repository = repository;
    }

    public List<TotalSaleOrder> listSale() {
        return this.repository.findTotalByClient();
    }
}
