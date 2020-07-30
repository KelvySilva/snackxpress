package br.com.sg.snackxpress.builder;

import br.com.sg.snackxpress.domain.order.SaleOrder;
import br.com.sg.snackxpress.domain.order.SaleOrderItem;
import br.com.sg.snackxpress.domain.person.Client;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public final class SaleOrderBuilder {
    private BigDecimal subtotal = BigDecimal.ZERO;
    private BigDecimal total = BigDecimal.ZERO;
    private BigDecimal discountAmount = BigDecimal.ZERO;
    private SaleOrder.STATUS status = SaleOrder.STATUS.PROGRESS;
    private Client client = ClientBuilder.aClient().build();
    private List<SaleOrderItem> itemList = Arrays.asList(new SaleOrderItem[]{SaleOrderItemBuilder.aSaleOrderItem().build()});
    private Long id;

    private SaleOrderBuilder() {
    }

    public static SaleOrderBuilder aSaleOrder() {
        return new SaleOrderBuilder();
    }

    public SaleOrderBuilder subtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
        return this;
    }

    public SaleOrderBuilder total(BigDecimal total) {
        this.total = total;
        return this;
    }

    public SaleOrderBuilder discountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
        return this;
    }

    public SaleOrderBuilder status(SaleOrder.STATUS status) {
        this.status = status;
        return this;
    }

    public SaleOrderBuilder client(Client client) {
        this.client = client;
        return this;
    }

    public SaleOrderBuilder itemList(List<SaleOrderItem> itemList) {
        this.itemList = itemList;
        return this;
    }

    public SaleOrderBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public SaleOrder build() {
        SaleOrder saleOrder = new SaleOrder();
        saleOrder.setSubtotal(subtotal);
        saleOrder.setTotal(total);
        saleOrder.setDiscountAmount(discountAmount);
        saleOrder.setStatus(status);
        saleOrder.setClient(client);
        saleOrder.setItemList(itemList);
        saleOrder.setId(id);
        return saleOrder;
    }
}
