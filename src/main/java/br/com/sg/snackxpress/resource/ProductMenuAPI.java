package br.com.sg.snackxpress.resource;

import br.com.sg.snackxpress.domain.menu.ProductMenu;
import br.com.sg.snackxpress.service.ProductMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1")
public class ProductMenuAPI {

    private ProductMenuService service;

    @Autowired
    public ProductMenuAPI(ProductMenuService service) {
        this.service = service;
    }

    @GetMapping(path = "protected/menus")
    public ResponseEntity listAll(){
        return ResponseEntity.ok(this.service.listAll());
    }

    @GetMapping(path = "protected/menu/{id}")
    public ResponseEntity findOne(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.findOne(id));
    }

    @PostMapping(path = "admin/menu")
    public ResponseEntity saveOne(@RequestBody ProductMenu menu) {
        return ResponseEntity.ok(this.service.saveOne(menu));
    }

    @PutMapping(path = "admin/menu/{id}")
    public ResponseEntity updateOne(@PathVariable Long id, @RequestBody ProductMenu menu){
        return ResponseEntity.ok(this.service.updateOne(id, menu));
    }
}
