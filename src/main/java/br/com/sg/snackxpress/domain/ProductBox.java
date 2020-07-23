package br.com.sg.snackxpress.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * ProductBox é o produto que é composto por dois ou mais
 * produtos ProductInd e/ou ProductComp
 */

@Getter
@Setter
public class ProductBox extends AbstractProduct {

    private List<AbstractProduct> productList;

    
}
