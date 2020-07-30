package br.com.sg.snackxpress.resource;

import br.com.sg.snackxpress.domain.payment.PaymentMethod;
import br.com.sg.snackxpress.service.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1")
public class PaymentMethodAPI {

    private PaymentMethodService service;

    @Autowired
    public PaymentMethodAPI(PaymentMethodService service) {
        this.service = service;
    }

    @GetMapping(path = "/protected/payment/methods")
    public ResponseEntity listAll(){
        return ResponseEntity.ok(this.service.listAll());
    }

    @GetMapping(path = "/protected/payment/method/{id}")
    public ResponseEntity findOne(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.findOne(id));
    }

    @PostMapping(path = "/admin/payment/method")
    public ResponseEntity saveOne(@RequestBody PaymentMethod method) {
        return ResponseEntity.ok(this.service.saveOne(method));
    }
}
