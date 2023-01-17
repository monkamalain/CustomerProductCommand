package ca.tmas.cpc.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Category extends EntityWithUUID implements Serializable {

    static final long serialVersionUID = 1L;

    @Column(name = "refCategory", nullable = false, unique = true)
    String refCategory;

    @Column(name = "nameCategory", nullable = false)
    String nameCategory;

    @ManyToOne
    Command commandCategory;

    @OneToMany(targetEntity = Product.class, mappedBy = "categoryProduct")
    List<Product> productListCategory = new ArrayList<>();

}
