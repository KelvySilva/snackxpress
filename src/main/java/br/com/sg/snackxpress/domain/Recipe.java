package br.com.sg.snackxpress.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Recipe extends AbstractEntity {

    @NotEmpty
    @NonNull
    @NotNull
    @NotBlank(message = "Nome não pode ser vazio ou nulo")
    private String name;

    @OneToMany
    private List<Ingredient> ingredientList;

}
