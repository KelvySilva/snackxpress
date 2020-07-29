package br.com.sg.snackxpress.domain.order;

import br.com.sg.snackxpress.domain.AbstractEntity;
import br.com.sg.snackxpress.domain.person.Client;
import br.com.sg.snackxpress.domain.person.Person;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
public class SaleOrder extends AbstractEntity {

    private BigDecimal subtotal;

    private BigDecimal total;

    private BigDecimal discountAmount;

    private STATUS status;

    @ManyToOne(cascade = CascadeType.ALL)
    private Client client;

    @OneToMany(cascade = CascadeType.ALL)
    private List<SaleOrderItem> itemList;

    public enum STATUS {

        PROGRESS("ABERTO"),
        PROCESSING("PROCESSANDO"),
        READY("PRONTO"),
        DELIVERY("ENTREGA"),
        CANCELED("CANCELADO"),
        FINISHED("FINALIZADO");

        private String desc;

        STATUS(String desc) {
            this.desc = desc;
        }
    }

}
