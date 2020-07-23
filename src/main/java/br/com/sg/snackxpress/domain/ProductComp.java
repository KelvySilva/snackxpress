package br.com.sg.snackxpress.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.OneToOne;

/**
 * ProductComp é o produto que é composto por Ingredient e/ou
 * precisa de processamento ou preparo para ser servido ao consumidor final.
 */

@Getter
@Setter
public class ProductComp extends AbstractProduct {

    @OneToOne
    private Recipe recipe;

}
