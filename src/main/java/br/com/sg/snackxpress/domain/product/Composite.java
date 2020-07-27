package br.com.sg.snackxpress.domain.product;

import br.com.sg.snackxpress.domain.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

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
