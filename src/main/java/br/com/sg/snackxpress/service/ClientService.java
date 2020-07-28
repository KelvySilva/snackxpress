package br.com.sg.snackxpress.service;

import br.com.sg.snackxpress.builder.ClientBuilder;
import br.com.sg.snackxpress.domain.person.Client;
import br.com.sg.snackxpress.error.ResourceNotFoundException;
import br.com.sg.snackxpress.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Service
public class ClientService {

    private ClientRepository respository;

    @Autowired
    public ClientService(ClientRepository respository) {
        this.respository = respository;
    }

    public List<Client> listAll() {
        List<Client> all = this.respository.findAll();
        if (all.isEmpty()) {
            throw new ResourceNotFoundException("Nenhum cliente foi cadastrado");
        }
        return all;
    }

    public Client findOne(Long id) {
        return this.respository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Cliente com id %s não foi encontrado", id)));
    }

    @Transactional
    public Client saveOne(Client client) {
        if (Objects.isNull(client.getName()) && Objects.isNull(client.getCpf())) {
            Client build = ClientBuilder.aClient().build();
            System.out.println(build);
            return this.respository.save(build);
        }
        return this.respository.save(client);
    }

    @Transactional
    public Client updateOne(Long id, Client client) {
        Client update = this.respository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Cliente com id %s não existe!", id)));
        if (Objects.nonNull(client.getName()) && !(update.getName().equals(client.getName()))) {
            update.setName(client.getName());
        }
        if (Objects.nonNull(client.getAddress()) && !(update.getAddress().equals(client.getAddress()))) {
            update.setAddress(client.getAddress());
        }
        if (Objects.nonNull(client.getAddressNumber()) && !(update.getAddressNumber().equals(client.getAddressNumber()))) {
            update.setAddressNumber(client.getAddressNumber());
        }
        if (Objects.nonNull(client.getAddressNumber()) && !(update.getAddressNumber().equals(client.getAddressNumber()))) {
            update.setAddressNumber(client.getAddressNumber());
        }
        if (Objects.nonNull(client.getAddressNumber()) && !(update.getAddressNumber().equals(client.getAddressNumber()))) {
            update.setAddressNumber(client.getAddressNumber());
        }
        if (Objects.nonNull(client.getCep()) && !(update.getCep().equals(client.getCep()))) {
            update.setCep(client.getCep());
        }

        Stream.of(client).forEach(e -> System.out.println(e));
        return null;
    }

    public void deleteOne(Long id) {
        this.respository.deleteById(id);
    }
}
