package br.com.sg.snackxpress.service;

import br.com.sg.snackxpress.builder.ClientBuilder;
import br.com.sg.snackxpress.domain.order.SaleOrder;
import br.com.sg.snackxpress.domain.person.Client;
import br.com.sg.snackxpress.error.ResourceNotFoundException;
import br.com.sg.snackxpress.repository.SaleOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class SaleOrderService {

    private SaleOrderRepository repository;

    @Autowired
    public SaleOrderService(SaleOrderRepository repository) {
        this.repository = repository;
    }


    public List<SaleOrder> listAll() {
        List<SaleOrder> all = this.repository.findAll();
        if (all.isEmpty()) {
            throw new ResourceNotFoundException("Nenhum pedido realizado");
        }
        return all;
    }

    public SaleOrder findOne(Long id) {
        return this.repository.findById(id)
                .orElseThrow(() ->
                            new ResourceNotFoundException(String.format("Peido do id: %s não encontrad", id))
                );
    }

    public SaleOrder saveOne(SaleOrder saleOrder) {
        if (Objects.isNull(saleOrder.getClient().getCpf())) {
            Client build = ClientBuilder.aClient().build();
            saleOrder.setClient(build);
        }
        return this.repository.save(saleOrder);
    }
}
