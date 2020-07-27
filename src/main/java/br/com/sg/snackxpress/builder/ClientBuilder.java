package br.com.sg.snackxpress.builder;

import br.com.sg.snackxpress.domain.person.Client;

public final class ClientBuilder {
    private String address = "N/A";
    private String addressNumber = "N/A";
    private String cep = "N/A";
    private String city = "N/A";
    private String state = "N/A";
    private String phone = "N/A";
    private String name = "CLIENTE FINAL";
    private String cpf = "N/A";

    private ClientBuilder() {
    }

    public static ClientBuilder aClient() {
        return new ClientBuilder();
    }

    public ClientBuilder address(String address) {
        this.address = address;
        return this;
    }

    public ClientBuilder addressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
        return this;
    }

    public ClientBuilder cep(String cep) {
        this.cep = cep;
        return this;
    }

    public ClientBuilder city(String city) {
        this.city = city;
        return this;
    }

    public ClientBuilder state(String state) {
        this.state = state;
        return this;
    }

    public ClientBuilder phone(String phone) {
        this.phone = phone;
        return this;
    }

    public ClientBuilder name(String name) {
        this.name = name;
        return this;
    }

    public ClientBuilder cpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public Client build() {
        Client client = new Client();
        client.setAddress(address);
        client.setAddressNumber(addressNumber);
        client.setCep(cep);
        client.setCity(city);
        client.setState(state);
        client.setPhone(phone);
        client.setName(name);
        client.setCpf(cpf);
        return client;
    }
}
