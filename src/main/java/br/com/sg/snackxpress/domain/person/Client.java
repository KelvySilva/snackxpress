package br.com.sg.snackxpress.domain.person;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Client extends Person {


    private String address;

    private String addressNumber;

    private String cep;

    private String city;

    private String state;

    private String phone;

    @Override
    public String toString() {
        return "Client{" +
                "\n id='" + this.getId() + '\'' +
                "\n, address='" + address + '\'' +
                "\n, addressNumber='" + addressNumber + '\'' +
                "\n, cep='" + cep + '\'' +
                "\n, city='" + city + '\'' +
                "\n, state='" + state + '\'' +
                "\n, phone='" + phone + '\'' +
                "\n"+'}';
    }


}
