package ca.tmas.cpc.model;

import ca.tmas.cpc.utils.MatrimonialStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends Person implements Serializable {

    static final long serialVersionUID = 1L;

    @Column(name = "refEmployee", nullable = false, unique = true)
    String refEmployee;

    @Column(name = "gender", nullable = false, length = 8)
    String gender;

    @Column(name = "age", nullable = false, length = 2)
    int age;

    @Column(name = "matrimonialStatus", nullable = false)
    @Enumerated(EnumType.STRING)
    MatrimonialStatus matrimonialStatus;

    @Column(name = "nas", nullable = false, length = 12)
    String nas;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    Byte[] picture;

    @ManyToOne
    Enterprise enterprise;

    @OneToMany(targetEntity = Payment.class, mappedBy = "employee")
    List<Payment> paymentListEmployee = new ArrayList<>();

    @OneToMany(targetEntity = Facture.class, mappedBy = "employeeFacture")
    List<Facture> factureList = new ArrayList<>();

}
