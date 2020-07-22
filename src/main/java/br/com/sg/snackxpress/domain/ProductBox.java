package br.com.sg.snackxpress.domain;

import br.com.sg.snackxpress.intereface.Stockable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * ProductBox é o produto que é composto por dois ou mais
 * produtos ProductInd e/ou ProductComp
 */

@Getter
@Setter
public class ProductBox extends Product{

    private List<Product> productList;

    
}
