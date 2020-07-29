package br.com.sg.snackxpress.domain.product;

import br.com.sg.snackxpress.domain.AbstractEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@Entity
@Getter
@Setter
public class Product extends AbstractEntity {

    @NotEmpty
    @NonNull
    @NotNull
    @NotBlank(message = "Nome não pode ser vazio ou nulo")
    protected String name;

    @NotEmpty
    @NonNull
    @NotNull
    @NotBlank(message = "Descrição não pode ser vazio ou nulo")
    protected StringBuffer description;

    protected BigDecimal cost;

    @OneToOne(cascade = CascadeType.ALL)
    private Stock stock = new Stock(0);

    @Enumerated(EnumType.STRING)
    protected TYPE type;

    public enum TYPE{

        COMPOSITE("COMPOSITE"),
        FINAL("FINAL");

        private String desc;

        TYPE(String desc) {
            this.desc = desc;
        }
    }

}
