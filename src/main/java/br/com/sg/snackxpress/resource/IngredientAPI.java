package br.com.sg.snackxpress.resource;

import br.com.sg.snackxpress.domain.Ingredient;
import br.com.sg.snackxpress.service.IngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1")
public class IngredientAPI {

    private IngredientService service;

    @GetMapping(path = "/protected/ingredient")
    public ResponseEntity listall() {
        return ResponseEntity.ok(this.service.listall());
    }

    @GetMapping(path = "/protected/ingredient/{id}")
    public ResponseEntity listOne(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.service.findOne(id));
    }

    @PostMapping(path = "/protected/ingredient")
    public ResponseEntity saveOne(@RequestBody Ingredient ingredient){
        return ResponseEntity.ok(this.service.saveOne(ingredient));
    }

    @PutMapping(path = "/protected/ingredient/{id}")
    public ResponseEntity updateOne(@RequestParam Long id, @RequestBody Ingredient ingredient) {
        return ResponseEntity.ok(this.service.updateOne(id, ingredient));
    }

}