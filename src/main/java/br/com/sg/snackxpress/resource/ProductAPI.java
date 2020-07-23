package br.com.sg.snackxpress.resource;

import br.com.sg.snackxpress.domain.*;
import br.com.sg.snackxpress.error.ResourceNotFoundException;
import br.com.sg.snackxpress.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

@RestController
@RequestMapping("v1")
public class ProductAPI {

    private ProductService service;

    @Autowired
    public ProductAPI(ProductService service) {
        this.service = service;
    }

    @GetMapping(path = "/protected/product")
    public ResponseEntity listAll(){
        return ResponseEntity.ok(this.service.listAll());
    }

    @GetMapping(path = "/protected/product/{id}")
    public ResponseEntity listOne(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.listOne(id));
    }

    @PostMapping(path = "/admin/product")
    public ResponseEntity saveOne(@RequestBody ProductComp product) {
        return ResponseEntity.ok(this.service.saveOneComp(product));
    }

    @PostMapping(path = "/admin/product/box")
    public ResponseEntity saveOne(@RequestBody ProductBox product) {
        return ResponseEntity.ok(this.service.saveOneBox(product));
    }

    @PostMapping(path = "/admin/product/ind")
    public ResponseEntity saveOne(@RequestBody ProductInd product) {
        return ResponseEntity.ok(this.service.saveOneInd(product));
    }


}
