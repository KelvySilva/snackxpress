package br.com.sg.snackxpress.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * ProductComp é o produto que é composto por Ingredient e/ou
 * precisa de processamento ou preparo para ser servido ao consumidor final.
 */

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ProductComp extends AbstractProduct implements Stockable {

    @ManyToMany
    private List<Ingredient> ingredients;

    @Override
    public void add() {
        this.ingredients.stream()
                .forEach(p -> p.getStock().setQuantity( p.getStock().getQuantity() +1));
    }

    @Override
    public void add(Integer number) {
        this.ingredients.stream()
                .forEach(p -> p.getStock().setQuantity( p.getStock().getQuantity() + number));
    }

    @Override
    public void subtract() {
        this.ingredients.stream()
                .forEach(p -> p.getStock().setQuantity( p.getStock().getQuantity() - 1));
    }

    @Override
    public void subtract(Integer numero) {
        this.ingredients.stream()
                .forEach(p -> p.getStock().setQuantity( p.getStock().getQuantity() - numero));
    }
}
