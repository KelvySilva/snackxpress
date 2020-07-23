package br.com.sg.snackxpress.domain;

import br.com.sg.snackxpress.domain.Stock;

import java.io.Serializable;

public interface Stockable extends Serializable {

    void add();

    void add(Integer number);

    void subtract();

    void subtract(Integer numero);
}
