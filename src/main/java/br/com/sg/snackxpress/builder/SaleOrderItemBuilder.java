package br.com.sg.snackxpress.builder;

import br.com.sg.snackxpress.domain.order.SaleOrderItem;
import br.com.sg.snackxpress.domain.product.ProductFinal;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public final class SaleOrderItemBuilder {
    private BigDecimal subtotal = BigDecimal.ZERO;
    private BigDecimal total = BigDecimal.ZERO;
    private BigDecimal discount = BigDecimal.ZERO;
    private List<ProductFinal> products = Arrays.asList(new ProductFinal[]{ProductFinalBuilder.aProductFinal().build(),ProductFinalBuilder.aProductFinal().build()});
    private Long id;

    private SaleOrderItemBuilder() {
    }

    public static SaleOrderItemBuilder aSaleOrderItem() {
        return new SaleOrderItemBuilder();
    }

    public SaleOrderItemBuilder subtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
        return this;
    }

    public SaleOrderItemBuilder total(BigDecimal total) {
        this.total = total;
        return this;
    }

    public SaleOrderItemBuilder discount(BigDecimal discount) {
        this.discount = discount;
        return this;
    }

    public SaleOrderItemBuilder products(List<ProductFinal> products) {
        this.products = products;
        return this;
    }

    public SaleOrderItemBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public SaleOrderItem build() {
        SaleOrderItem saleOrderItem = new SaleOrderItem();
        saleOrderItem.setSubtotal(subtotal);
        saleOrderItem.setTotal(total);
        saleOrderItem.setDiscount(discount);
        saleOrderItem.setProducts(products);
        saleOrderItem.setId(id);
        return saleOrderItem;
    }
}
