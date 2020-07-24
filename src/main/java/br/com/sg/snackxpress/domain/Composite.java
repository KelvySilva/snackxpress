package br.com.sg.snackxpress.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.OneToOne;

@Getter
@Setter
public class Composite extends AbstractEntity {

    @OneToOne
    private Ingredient ingredient;

    private Integer quantity;

}
