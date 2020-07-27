package br.com.sg.snackxpress.domain.person;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class Employee extends Person {

    private String username;

    private String password;
}
