package br.com.sg.snackxpress.domain.product;

import java.io.Serializable;

public interface Stockable extends Serializable {

    void add();

    void add(Integer number);

    void subtract();

    void subtract(Integer numero);
}
