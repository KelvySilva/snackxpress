package br.com.sg.snackxpress.domain;

import br.com.sg.snackxpress.intereface.Stockable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * ProductBox é o produto que é composto por dois ou mais
 * produtos ProductInd e/ou ProductComp
 */

@Getter
@Setter
public class ProductBox extends Product implements Stockable {

    @Override
    public Stock add(Stock stock) {
        stock.setProduct(this);
        stock.setQuantity( stock.getQuantity() + 1);
        return stock;
    }

    @Override
    public Stock add(Stock stock, Integer number) {
        stock.setProduct(this);
        stock.setQuantity( stock.getQuantity() + number);
        return stock;
    }

    @Override
    public Stock subtract(Stock stock) {
        stock.setProduct(this);
        stock.setQuantity( stock.getQuantity() - 1);
        return stock;
    }

    @Override
    public Stock subtract(Stock stock, Integer numero) {
        stock.setProduct(this);
        stock.setQuantity( stock.getQuantity() - numero);
        return stock;
    }
}
