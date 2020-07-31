package br.com.sg.snackxpress.domain.order;

import br.com.sg.snackxpress.domain.AbstractEntity;
import br.com.sg.snackxpress.domain.product.Product;
import br.com.sg.snackxpress.domain.product.ProductFinal;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
public class SaleOrderItem extends AbstractEntity {

    private BigDecimal subtotal;

    private BigDecimal total;

    private BigDecimal discount;

    @ManyToMany( fetch = FetchType.LAZY)
    private List<ProductFinal> products;

    @Override
    public String toString() {
        return "SaleOrderItem{" +
                "\n  id=" + this.getId() +
                "\n, subtotal=" + subtotal +
                "\n, total=" + total +
                "\n, discount=" + discount +
                "\n, products=" + products +
                "\n"+'}';
    }
}
