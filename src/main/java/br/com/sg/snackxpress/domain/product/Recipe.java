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
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Recipe extends AbstractEntity {

    @NotNull
    @NotEmpty
    @NotBlank
    private String name;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Composite> composities;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private ProductFinal productFinal;
}
