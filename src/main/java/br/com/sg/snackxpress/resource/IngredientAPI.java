package br.com.sg.snackxpress.resource;

import br.com.sg.snackxpress.domain.product.Ingredient;
import br.com.sg.snackxpress.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1")
@CrossOrigin
public class IngredientAPI {

    private IngredientService service;

    @Autowired
    public IngredientAPI(IngredientService service) {
        this.service = service;
    }

    @GetMapping(path = "/protected/ingredients")
    public ResponseEntity listall() {
        return ResponseEntity.ok(this.service.listall());
    }

    @GetMapping(path = "/protected/ingredient/{id}")
    public ResponseEntity listOne(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.service.findOne(id));
    }

    @PostMapping(path = "/admin/ingredient")
    public ResponseEntity saveOne(@RequestBody Ingredient ingredient){
        return ResponseEntity.ok(this.service.saveOne(ingredient));
    }

    @PutMapping(path = "/admin/ingredient/{id}")
    public ResponseEntity updateOne(@PathVariable Long id, @RequestBody Ingredient ingredient) {
        return ResponseEntity.ok(this.service.updateOne(id, ingredient));
    }

    @DeleteMapping(path = "/admin/ingredient/{id}")
    public ResponseEntity deleteOne(@PathVariable Long id) {
        this.service.deleteOne(id);
        return ResponseEntity.accepted().build();
    }

}
