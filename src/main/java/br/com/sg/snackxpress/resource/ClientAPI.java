package br.com.sg.snackxpress.resource;


import br.com.sg.snackxpress.domain.person.Client;
import br.com.sg.snackxpress.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.Arrays;

@RestController
@RequestMapping("v1")
public class ClientAPI {

    private ClientService service;

    @Autowired
    public ClientAPI(ClientService service) {
        this.service = service;
    }

    @GetMapping(path = "/protected/clients")
    public ResponseEntity listAll() {
        return ResponseEntity.ok(this.service.listAll());
    }

    @GetMapping(path = "/protected/client/{id}")
    public ResponseEntity findOne(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.findOne(id));
    }

    @PostMapping(path = "/admin/client")
    public ResponseEntity saveOne(Client client) {
        return ResponseEntity.ok(this.service.saveOne(client));
    }

    @PutMapping(path = "/admin/client/{id}")
    public ResponseEntity updateOne(@PathVariable Long id, @RequestBody Client client) {
        return ResponseEntity.ok(this.service.updateOne(id,client));
    }

    @DeleteMapping(path = "/admin/client/{id}")
    public ResponseEntity deleteOne(@PathVariable Long id) {
        this.service.deleteOne(id);
        return ResponseEntity.accepted().build();
    }
}
