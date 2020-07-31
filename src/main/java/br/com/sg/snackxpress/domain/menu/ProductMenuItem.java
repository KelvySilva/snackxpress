package br.com.sg.snackxpress.domain.menu;

import br.com.sg.snackxpress.domain.AbstractEntity;
import br.com.sg.snackxpress.domain.product.ProductFinal;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Setter
@Getter
public class ProductMenuItem extends AbstractEntity {

    private BigDecimal discountAmount = BigDecimal.ZERO;

    private BigDecimal subtotal = BigDecimal.ZERO;

    private BigDecimal total = BigDecimal.ZERO;

    @Enumerated(EnumType.STRING)
    private CATEGORY category;

    @ManyToMany
    private List<ProductFinal> list;


    public enum CATEGORY {

        SNACK("LANCHE"),
        DRINK("BEBIDA"),
        COMBO("COMBO");

        private String desc;

        CATEGORY(String desc) {
            this.desc = desc;
        }
    }

}
