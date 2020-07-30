package br.com.sg.snackxpress;

import br.com.sg.snackxpress.builder.ClientBuilder;
import br.com.sg.snackxpress.builder.SaleOrderBuilder;
import br.com.sg.snackxpress.domain.order.SaleOrder;
import br.com.sg.snackxpress.error.ErrorDetails;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.event.annotation.BeforeTestExecution;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(properties = "apllication-test.yml",classes = SnackxpressApplicationStart.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc()
public class SaleOrderAPITest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private WebApplicationContext context;

    @LocalServerPort
    int port;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }


    @Test
    public void createOrderShouldReturnStatusCode404NotFound() throws Exception {

        SaleOrder saleOrder = SaleOrderBuilder.aSaleOrder()
                .client(ClientBuilder.aClient().id(10L).build()).build();

        String valueAsString = mapper.writeValueAsString(saleOrder);
        MediaType MEDIA_TYPE_JSON_UTF8 = new MediaType("application", "json", Charset.forName("UTF-8"));

        MockHttpServletRequestBuilder post = post("/v1/admin/order");
        post.content(valueAsString);
        post.accept(MEDIA_TYPE_JSON_UTF8);
        post.contentType(MEDIA_TYPE_JSON_UTF8);

        MvcResult result = mockMvc.perform(post)
                .andExpect(status().isNotFound()).andReturn();
        String resultContentAsString = result.getResponse().getContentAsString();
        ErrorDetails exception = mapper.readValue(resultContentAsString, ErrorDetails.class);
        assertEquals(HttpStatus.NOT_FOUND.value(),result.getResponse().getStatus());
        assertEquals("Resource not found", exception.getTitle());
    }

    @Test
    public void listAllShouldReturnStatusCode404NotFound() throws Exception {
        MediaType MEDIA_TYPE_JSON_UTF8 = new MediaType("application", "json", Charset.forName("UTF-8"));
        MockHttpServletRequestBuilder get = get("/v1/protected/orders");
        get.accept(MEDIA_TYPE_JSON_UTF8);
        get.contentType(MEDIA_TYPE_JSON_UTF8);
        MvcResult result = this.mockMvc.perform(get)
                .andExpect(status().isNotFound()).andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        ErrorDetails error = mapper.readValue(contentAsString, ErrorDetails.class);
        assertEquals(HttpStatus.NOT_FOUND.value(),result.getResponse().getStatus());
    }

    @Test
    public void createOrderShouldReturnStatusCode200Ok() throws Exception {

        SaleOrder saleOrder = SaleOrderBuilder.aSaleOrder().build();

        String valueAsString = mapper.writeValueAsString(saleOrder);
        MediaType MEDIA_TYPE_JSON_UTF8 = new MediaType("application", "json", Charset.forName("UTF-8"));

        MockHttpServletRequestBuilder post = post("/v1/admin/order");
        post.content(valueAsString);
        post.accept(MEDIA_TYPE_JSON_UTF8);
        post.contentType(MEDIA_TYPE_JSON_UTF8);

        MvcResult result = this.mockMvc.perform(post)
                .andExpect(status().isOk()).andReturn();
        String resultContentAsString = result.getResponse().getContentAsString();
        SaleOrder order = mapper.readValue(resultContentAsString, SaleOrder.class);
        assertEquals(HttpStatus.OK.value(),result.getResponse().getStatus());
        assertEquals(SaleOrder.STATUS.PROGRESS,order.getStatus() );
        assertTrue(order.getId() > 0);
        assertEquals(BigDecimal.TEN.add(BigDecimal.TEN),order.getTotal());
    }



    @Test
    public void listAllShouldReturnStatusCode200Ok() throws Exception {
        SaleOrder saleOrder = SaleOrderBuilder.aSaleOrder().build();

        String valueAsStringToTest = mapper.writeValueAsString(saleOrder);
        MediaType MEDIA_TYPE_JSON_UTF8 = new MediaType("application", "json", Charset.forName("UTF-8"));

        MockHttpServletRequestBuilder post = post("/v1/admin/order");
        post.content(valueAsStringToTest);
        post.accept(MEDIA_TYPE_JSON_UTF8);
        post.contentType(MEDIA_TYPE_JSON_UTF8);

        MvcResult resultToTest = mockMvc.perform(post).andExpect(status().isOk()).andReturn();
        String resultContentAsString = resultToTest.getResponse().getContentAsString();
        SaleOrder order = mapper.readValue(resultContentAsString, SaleOrder.class);

        MockHttpServletRequestBuilder get = get("/v1/protected/orders");
        get.accept(MEDIA_TYPE_JSON_UTF8);
        get.contentType(MEDIA_TYPE_JSON_UTF8);
        MvcResult result = this.mockMvc.perform(get)
                .andExpect(status().isOk()).andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        SaleOrder[] saleOrders = mapper.readValue(contentAsString, SaleOrder[].class);
        assertEquals(HttpStatus.OK.value(),result.getResponse().getStatus());
    }

    @Test
    public void listOneShouldReturnStatusCode200Ok() throws Exception {
        SaleOrder saleOrder = SaleOrderBuilder.aSaleOrder().build();

        String valueAsStringToTest = mapper.writeValueAsString(saleOrder);
        MediaType MEDIA_TYPE_JSON_UTF8 = new MediaType("application", "json", Charset.forName("UTF-8"));

        MockHttpServletRequestBuilder post = post("/v1/admin/order");
        post.content(valueAsStringToTest);
        post.accept(MEDIA_TYPE_JSON_UTF8);
        post.contentType(MEDIA_TYPE_JSON_UTF8);

        MvcResult resultToTest = mockMvc.perform(post).andExpect(status().isOk()).andReturn();
        String resultContentAsString = resultToTest.getResponse().getContentAsString();
        SaleOrder order = mapper.readValue(resultContentAsString, SaleOrder.class);
        Long id = order.getId();

        String valueAsString = mapper.writeValueAsString(id);

        MockHttpServletRequestBuilder get = get("/v1/protected/order/"+valueAsString);
        get.accept(MEDIA_TYPE_JSON_UTF8);
        MvcResult result = this.mockMvc.perform(get)
                .andExpect(status().isOk()).andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        SaleOrder saleOrders = mapper.readValue(contentAsString, SaleOrder.class);
        assertEquals(HttpStatus.OK.value(),result.getResponse().getStatus());
    }



}
