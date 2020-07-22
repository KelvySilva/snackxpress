package br.com.sg.snackxpress.domain;

import br.com.sg.snackxpress.intereface.Stockable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Stock extends AbstractEntity {

    private Long entityId;

    private STOCK_TYPE type;

    private Integer quantity;

    public static enum STOCK_TYPE {

        PRODUCT("PRODUTO"),
        INGREDIENT("INGREDIENTE");

        private String desc;

        STOCK_TYPE(String desc){
            this.desc = desc;
        }
    }

}
