package br.com.sg.snackxpress.resource;

import br.com.sg.snackxpress.domain.order.SaleOrder;
import br.com.sg.snackxpress.service.SaleOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1")
public class SaleOrderAPI {

    private SaleOrderService service;

    @Autowired
    public SaleOrderAPI(SaleOrderService service) {
        this.service = service;
    }

    @GetMapping(path = "/protected/orders")
    public ResponseEntity listAll() {
        return ResponseEntity.ok(this.service.listAll());
    }

    @GetMapping(path = "protected/order/{id}")
    public ResponseEntity findOne(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.findOne(id));
    }

    @PostMapping(path = "/admin/order")
    public ResponseEntity saveOne(@RequestBody SaleOrder saleOrder) {
        return ResponseEntity.ok(this.service.saveOne(saleOrder));
    }
}
