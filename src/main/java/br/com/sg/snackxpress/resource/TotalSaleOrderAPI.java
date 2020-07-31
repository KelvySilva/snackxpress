package br.com.sg.snackxpress.resource;

import br.com.sg.snackxpress.service.TotalSaleOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1")
public class TotalSaleOrderAPI {

    private TotalSaleOrderService service;

    @Autowired
    public TotalSaleOrderAPI(TotalSaleOrderService service) {
        this.service = service;
    }

    @GetMapping(path = "/protected/order/total")
    public ResponseEntity listByClient() {
        return ResponseEntity.ok(this.service.listSale());
    }

}
