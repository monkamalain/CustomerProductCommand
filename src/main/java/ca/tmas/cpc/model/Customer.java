package ca.tmas.cpc.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer extends Person implements Serializable {

    static final long serialVersionUID = 1L;

    @Column(name = "refCostumer", nullable = false, unique = true)
    String refCostumer;

    @OneToMany(targetEntity = Payment.class, mappedBy = "customer")
    List<Payment> paymentListCustomer = new ArrayList<>();

}
