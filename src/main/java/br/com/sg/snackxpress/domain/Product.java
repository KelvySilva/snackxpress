package br.com.sg.snackxpress.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
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
    @NotBlank(message = "Preço não pode ser vazio ou nulo")
    protected StringBuffer description;

    protected BigDecimal cost;

    @OneToOne
    private Stock stock;

    protected TYPE type;

    public enum TYPE{

        COMPOSTO("COMPOSTO"),
        FINAL("FINAL");

        private String desc;

        TYPE(String desc) {
            this.desc = desc;
        }
    }

}
