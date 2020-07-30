package br.com.sg.snackxpress.domain.menu;

import br.com.sg.snackxpress.domain.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class ProductMenu extends AbstractEntity {

    private String name;

    @ManyToMany
    private List<ProductMenuItem> list;

}
