package ca.tmas.cpc.model;

import ca.tmas.cpc.utils.PaymentType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment extends EntityWithUUID implements Serializable {

    static final long serialVersionUID = 1L;

    @Column(name = "refPayment", nullable = false, unique = true)
    String refPayment;

    @Column(name = "amountPayment", nullable = false)
    double amountPayment;

    @Column(name = "paymentDate", nullable = false)
    LocalDateTime paymentDate;

    @Column(name = "paymentType", nullable = false)
    @Enumerated(EnumType.STRING)
    PaymentType paymentType;

    @ManyToOne
    Customer customer;

    @ManyToOne
    Employee employee;

    @OneToOne
    Facture facturePayment;

}
