package br.com.sg.snackxpress.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * ProductInd é o produto que não precisa de nenhum
 * tipo de processamento ou preparo para ser servido ao consumidor final.
 */

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ProductInd extends AbstractProduct implements Stockable{
    @Override
    public void add() {
        this.stock.setQuantity(this.stock.getQuantity() + 1);
    }

    @Override
    public void add(Integer number) {
        this.stock.setQuantity(this.stock.getQuantity() + number);
    }

    @Override
    public void subtract() {
        this.stock.setQuantity(this.stock.getQuantity() - 1);
    }

    @Override
    public void subtract(Integer numero) {
        this.stock.setQuantity(this.stock.getQuantity() + numero);
    }
}
