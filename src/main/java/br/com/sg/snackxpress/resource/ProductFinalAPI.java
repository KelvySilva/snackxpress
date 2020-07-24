package br.com.sg.snackxpress.resource;

import br.com.sg.snackxpress.domain.ProductFinal;
import br.com.sg.snackxpress.service.ProductFinalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1")
public class ProductFinalAPI {

    private ProductFinalService service;

    @Autowired
    public ProductFinalAPI(ProductFinalService service) {
        this.service = service;
    }

    @GetMapping(path = "/protected/products")
    public ResponseEntity listAll(){
        return ResponseEntity.ok(this.service.listAll());
    }

    @GetMapping(path = "/protected/product/{id}")
    public ResponseEntity listOne(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.listOne(id));
    }

    @PostMapping(path = "/admin/product")
    public ResponseEntity saveOne(@RequestBody ProductFinal product) {
        return ResponseEntity.ok(this.service.saveOne(product));
    }
    @PutMapping(path = "/admin/product/{id}")
    public ResponseEntity updateOne(@PathVariable Long id, @RequestBody ProductFinal productFinal) {
        return ResponseEntity.ok(this.service.updateOne(id, productFinal));
    }



}
