package br.com.sg.snackxpress.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product extends AbstractEntity {

    @NotBlank(message = "Nome não pode ser vazio ou nulo")
    @NotEmpty
    @NonNull
    @NotNull
    private String name;

    @NotBlank(message = "Preço não pode ser vazio ou nulo")
    @NotEmpty
    @NonNull
    @NotNull
    private BigDecimal price;





}
