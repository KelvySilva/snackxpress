package br.com.sg.snackxpress.domain;

import br.com.sg.snackxpress.domain.Stock;

import java.io.Serializable;

public interface Stockable extends Serializable {

    Stock add(Stock stock);

    Stock add(Stock stock, Integer number);

    Stock subtract(Stock stock);

    Stock subtract(Stock stock, Integer numero);
}
