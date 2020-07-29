package br.com.sg.snackxpress.domain.product;

import br.com.sg.snackxpress.domain.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Stock extends AbstractEntity {

    @Column(columnDefinition = "INTEGER DEFAULT 0", nullable = false)
    private Integer quantity;

    public Stock(Integer quantity) {
        this.quantity = quantity;
    }

}
