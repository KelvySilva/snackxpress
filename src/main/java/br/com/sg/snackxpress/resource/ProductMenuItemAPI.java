package br.com.sg.snackxpress.resource;

import br.com.sg.snackxpress.domain.menu.ProductMenuItem;
import br.com.sg.snackxpress.service.ProductMenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1")
public class ProductMenuItemAPI {

    private ProductMenuItemService service;

    @Autowired
    public ProductMenuItemAPI(ProductMenuItemService service) {
        this.service = service;
    }


    @GetMapping(path = "/protected/menu/items")
    public ResponseEntity listAll(){
        return ResponseEntity.ok(this.service.listAll());
    }

    @GetMapping(path = "/protected/menu/item/{id}")
    public ResponseEntity findOne(@PathVariable Long id){
        return ResponseEntity.ok(this.service.findOne(id));
    }

    @PostMapping(path = "/admin/menu/item")
    public ResponseEntity saveOne(@RequestBody ProductMenuItem item) {
        return ResponseEntity.ok(this.service.saveOne(item));
    }

    @PutMapping(path = "/admin/menu/item/{id}")
    public ResponseEntity updateOne(@PathVariable Long id, @RequestBody ProductMenuItem item) {
        return ResponseEntity.ok(this.service.updateOne(id, item));
    }
}
