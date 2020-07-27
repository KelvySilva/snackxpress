package br.com.sg.snackxpress.domain.person;

import br.com.sg.snackxpress.domain.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class Person extends AbstractEntity {

    private String name;

    @Column(unique = true,nullable = true)
    private String cpf;
}
