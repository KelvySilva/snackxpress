package br.com.sg.snackxpress.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * ProductBox é o produto que é composto por dois ou mais
 * produtos ProductInd e/ou ProductComp
 */

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ProductBox extends AbstractProduct implements Stockable {

    @ManyToMany
        private List<AbstractProduct> productList;


    @Override
    public void add() {
        this.productList.stream()
                .forEach(p -> p.stock.setQuantity( p.stock.getQuantity() +1));
    }

    @Override
    public void add(Integer number) {
        this.productList.stream()
                .forEach(p -> p.stock.setQuantity( p.stock.getQuantity() + number));
    }

    @Override
    public void subtract() {
        this.productList.stream()
                .forEach(p -> p.stock.setQuantity( p.stock.getQuantity() - 1));
    }

    @Override
    public void subtract(Integer numero) {
        this.productList.stream()
                .forEach(p -> p.stock.setQuantity( p.stock.getQuantity() - numero));
    }
}
