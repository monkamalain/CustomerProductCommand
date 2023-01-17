package ca.tmas.cpc.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Facture extends EntityWithUUID implements Serializable {

    static final long serialVersionUID = 1L;

    @Column(name = "refFacture", nullable = false, unique = true)
    String refFacture;

    @Column(name = "cashNumber", nullable = false, length = 1)
    int cashNumber;

    @Column(name = "factureDate", nullable = false)
    LocalDateTime factureDate;

    @Column(name = "totalFacture", nullable = false)
    double totalFacture;

    @Column(name = "amountCollected", nullable = true)
    double amountCollected;

    @Column(name = "amountReimbursed", nullable = true)
    double amountReimbursed;

    @OneToOne
    @JoinColumn(name = "facturePayment", nullable = false)
    Payment paymentFacture;

    @ManyToOne
    Employee employeeFacture;

    @OneToMany(targetEntity = Command.class, mappedBy = "factureCommand")
    List<Command> commandListFacture = new ArrayList<>();

}
