package br.com.sg.snackxpress.resource;

import br.com.sg.snackxpress.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1")
public class StockAPI {

    private StockService service;

    @Autowired
    public StockAPI(StockService service) {
        this.service = service;
    }


}
