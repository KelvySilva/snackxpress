package br.com.sg.snackxpress.resource;

import br.com.sg.snackxpress.domain.product.Recipe;
import br.com.sg.snackxpress.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("v1")
@CrossOrigin
public class RecipeAPI {

    private RecipeService service;

    @Autowired
    public RecipeAPI(RecipeService service) {
        this.service = service;
    }

    @GetMapping(path = "/protected/recipes")
    public ResponseEntity findAll() {
        return ResponseEntity.ok(this.service.findAll());
    }

    @GetMapping(path = "/protected/recipe/{id}")
    public ResponseEntity findOne(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.findOne(id));
    }

    @PostMapping(path = "/admin/recipe")
    public ResponseEntity saveOne(@Valid @RequestBody Recipe recipe) {
        Recipe recipe1 = this.service.saveOne(recipe);
        return ResponseEntity.ok(this.service.findOne(recipe1.getId()));
    }
}
