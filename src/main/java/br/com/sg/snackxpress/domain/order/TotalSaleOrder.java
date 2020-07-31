package br.com.sg.snackxpress.domain.order;

import br.com.sg.snackxpress.domain.AbstractEntity;
import br.com.sg.snackxpress.domain.person.Client;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TotalSaleOrder extends AbstractEntity {

    private String name;

    private BigDecimal total;

    private Long quantity;

    public TotalSaleOrder(Long id, String name, Long quantity, BigDecimal total) {
        this.name = name;
        this.id = id;
        this.total = total;
        this.quantity = quantity;
    }

}
