package br.com.sg.snackxpress.domain.payment;

import br.com.sg.snackxpress.domain.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
public class PaymentMethod extends AbstractEntity {

    @NotNull
    @NotEmpty
    private String name;

}
