package ca.tmas.cpc.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product extends EntityWithUUID implements Serializable {

    static final long serialVersionUID = 1L;

    @Column(name = "refProduct", nullable = false, unique = true)
    String refProduct;

    @Column(name = "nameProduct", nullable = false)
    String nameProduct;

    @Column(name = "descriptionProduct", nullable = false)
    String descriptionProduct;

    @Column(name = "priceProduct", nullable = false)
    double priceProduct;

    @Column(name = "stateProduct", nullable = false)
    String stateProduct;

    @Column(name = "creationDateProduct", nullable = false)
    LocalDateTime creationDateProduct;

    @Column(name = "dateSaleProduct", nullable = true)
    LocalDateTime dateSaleProduct;

    @ManyToOne
    Category categoryProduct;

}
