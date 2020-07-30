package br.com.sg.snackxpress.builder;

import br.com.sg.snackxpress.domain.product.Product;
import br.com.sg.snackxpress.domain.product.ProductFinal;
import br.com.sg.snackxpress.domain.product.Stock;

import java.math.BigDecimal;

public final class ProductFinalBuilder {
    protected String name = "Produto Teste 01";
    protected StringBuffer description = new StringBuffer("Um produto para teste");
    protected BigDecimal cost = BigDecimal.ZERO;
    protected Product.TYPE type = Product.TYPE.FINAL;
    private BigDecimal price = BigDecimal.TEN;
    private BigDecimal discount = BigDecimal.ZERO;
    private Stock stock = new Stock(0);
    private Long id;

    private ProductFinalBuilder() {
    }

    public static ProductFinalBuilder aProductFinal() {
        return new ProductFinalBuilder();
    }

    public ProductFinalBuilder price(BigDecimal price) {
        this.price = price;
        return this;
    }

    public ProductFinalBuilder discount(BigDecimal discount) {
        this.discount = discount;
        return this;
    }

    public ProductFinalBuilder name(String name) {
        this.name = name;
        return this;
    }

    public ProductFinalBuilder description(StringBuffer description) {
        this.description = description;
        return this;
    }

    public ProductFinalBuilder cost(BigDecimal cost) {
        this.cost = cost;
        return this;
    }

    public ProductFinalBuilder stock(Stock stock) {
        this.stock = stock;
        return this;
    }

    public ProductFinalBuilder type(Product.TYPE type) {
        this.type = type;
        return this;
    }

    public ProductFinalBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public ProductFinal build() {
        ProductFinal productFinal = new ProductFinal();
        productFinal.setPrice(price);
        productFinal.setDiscount(discount);
        productFinal.setName(name);
        productFinal.setDescription(description);
        productFinal.setCost(cost);
        productFinal.setStock(stock);
        productFinal.setType(type);
        productFinal.setId(id);
        return productFinal;
    }
}
