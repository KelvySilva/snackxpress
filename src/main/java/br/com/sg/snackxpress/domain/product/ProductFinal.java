package br.com.sg.snackxpress.domain.product;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class ProductFinal extends Product{

    private BigDecimal price;

    @Column(columnDefinition = "NUMERIC(19,2) DEFAULT 0.00")
    private BigDecimal discount;


}
