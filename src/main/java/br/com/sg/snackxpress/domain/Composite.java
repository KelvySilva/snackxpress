package br.com.sg.snackxpress.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Getter
@Setter
@Entity
public class Composite extends AbstractEntity {

    /**
     * Muitos Compostos podem ter um ingrediente
     * Um ingrediente pode estar em muitos compostos
     */
    @ManyToOne
    private Ingredient ingredient;

    private Integer quantity;

}
