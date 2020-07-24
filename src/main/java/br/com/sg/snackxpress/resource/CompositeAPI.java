package br.com.sg.snackxpress.resource;

import br.com.sg.snackxpress.service.CompositeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1")
public class CompositeAPI {

    private CompositeService service;

    @Autowired
    public CompositeAPI(CompositeService service) {
        this.service = service;
    }

    @GetMapping(path = "/protected/composities")
    public ResponseEntity listAll() {
        return ResponseEntity.ok(this.service.listAll());
    }
}
