package br.com.sg.snackxpress;

import br.com.sg.snackxpress.builder.ClientBuilder;
import br.com.sg.snackxpress.builder.ProductFinalBuilder;
import br.com.sg.snackxpress.domain.order.SaleOrder;
import br.com.sg.snackxpress.domain.order.SaleOrderItem;
import br.com.sg.snackxpress.domain.person.Client;
import br.com.sg.snackxpress.domain.product.Product;
import br.com.sg.snackxpress.domain.product.ProductFinal;
import br.com.sg.snackxpress.repository.SaleOrderRepository;
import br.com.sg.snackxpress.service.SaleOrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.BIG_DECIMAL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.HttpMethod.POST;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(properties = "apllication-test.yml",classes = SnackxpressApplicationStart.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc()
public class SaleOrderAPITest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SaleOrderService service;

    @LocalServerPort
    int port;

    @MockBean
    private SaleOrderRepository repository;

    @Test
    public void sendOrderCorrectlyShouldReturnStatusCode200(){


        Client build = ClientBuilder.aClient().build();


        SaleOrder saleOrder = new SaleOrder();
        saleOrder.setSubtotal(BigDecimal.ZERO);
        saleOrder.setTotal(BigDecimal.ZERO);
        saleOrder.setDiscountAmount(BigDecimal.ZERO);
        saleOrder.setClient(build);

        SaleOrderItem saleOrderItem = new SaleOrderItem();
        saleOrderItem.setDiscount(BigDecimal.ZERO);
        saleOrderItem.setSubtotal(BigDecimal.ZERO);
        saleOrderItem.setTotal(BigDecimal.ZERO);
        List<SaleOrderItem> items = new ArrayList<>();

        List<ProductFinal> products = new ArrayList<>();
        ProductFinal produto_de_teste = ProductFinalBuilder.aProductFinal()
                .id(1L)
                .name("Produto Teste 01")
                .price(BigDecimal.valueOf(27.01))
                .cost(BigDecimal.valueOf(20.01))
                .type(Product.TYPE.FINAL)
                .description(new StringBuffer("Produto de teste"))
                .discount(BigDecimal.valueOf(1.00))
                .build();

        products.add(produto_de_teste);

        saleOrderItem.setProducts(products);
//        saleOrderItem.setId(2L);

        items.add(saleOrderItem);

        saleOrder.setItemList(items);

        this.restTemplate.getRestTemplate().setInterceptors(Collections.singletonList(new RequestResponseLoggingInterceptor()));
        ResponseEntity<String> response =
                this.restTemplate.postForEntity("/v1/admin/order", saleOrder,String.class);

        System.out.println(String.format("%s\n %s\n %s\n",response.getBody(),response.getHeaders(),response.getStatusCode()));
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);



    }

    @Test
    public void sendOrderCorrectlyShouldReturnStatusCode200_OK(){


        Client build = ClientBuilder.aClient().build();


        SaleOrder saleOrder = new SaleOrder();
        saleOrder.setSubtotal(BigDecimal.ZERO);
        saleOrder.setTotal(BigDecimal.ZERO);
        saleOrder.setDiscountAmount(BigDecimal.ZERO);
        saleOrder.setClient(build);

        SaleOrderItem saleOrderItem = new SaleOrderItem();
        saleOrderItem.setDiscount(BigDecimal.ZERO);
        saleOrderItem.setSubtotal(BigDecimal.ZERO);
        saleOrderItem.setTotal(BigDecimal.ZERO);
        List<SaleOrderItem> items = new ArrayList<>();

        List<ProductFinal> products = new ArrayList<>();
        ProductFinal produto_de_teste = ProductFinalBuilder.aProductFinal()
                .id(1L)
                .name("Produto Teste 01")
                .price(BigDecimal.valueOf(27.01))
                .cost(BigDecimal.valueOf(20.01))
                .type(Product.TYPE.FINAL)
                .description(new StringBuffer("Produto de teste"))
                .discount(BigDecimal.valueOf(1.00))
                .build();

        products.add(produto_de_teste);

        saleOrderItem.setProducts(products);
//        saleOrderItem.setId(2L);

        items.add(saleOrderItem);

        saleOrder.setItemList(items);

        this.restTemplate.getRestTemplate().setInterceptors(Collections.singletonList(new RequestResponseLoggingInterceptor()));
        HttpEntity<SaleOrder> entity = new HttpEntity<>(saleOrder);
        ResponseEntity<String> response =
                this.restTemplate.exchange("/v1/admin/order",POST, entity,String.class);

        System.out.println(String.format("Body: %s\nHeaders: %s\nStatus: %s\n",response.getBody(),response.getHeaders(),response.getStatusCode()));
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);



    }


}
