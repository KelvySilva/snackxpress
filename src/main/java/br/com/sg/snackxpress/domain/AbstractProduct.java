package br.com.sg.snackxpress.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Optional;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AbstractProduct extends AbstractEntity {

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

    protected BigDecimal price;


    @OneToOne(cascade = CascadeType.ALL)
    protected Stock stock;



}
