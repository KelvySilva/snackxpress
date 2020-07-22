package br.com.sg.snackxpress.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

/**
 * ProductComp é o produto que é composto por Ingredient e/ou
 * precisa de processamento ou preparo para ser servido ao consumidor final.
 */

@Getter
@Setter
public class ProductComp extends Product {

    @ManyToMany
    private List<Ingredient> ingredients;

}
