package ca.tmas.cpc.model;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ChequePayment extends Payment implements Serializable {

    static final long serialVersionUID = 1L;

    @Column(name = "refCheque", nullable = false, unique = true)
    String refCheque;

    @Column(name = "nameCustomer", nullable = false)
    String nameCustomer;

    @Embedded
    @AttributeOverrides(value={
            @AttributeOverride(name = "addressLine1", column = @Column(name = "houseNumber", insertable = true, updatable = true, nullable = true, length = 5)),
            @AttributeOverride(name = "addressLine2", column = @Column(name = "street", insertable = true, updatable = true, nullable = true)),
            @AttributeOverride(name = "addressLine3", column = @Column(name = "zipCode", insertable = true, updatable = true, nullable = true, length = 7))
    })
    Address address;

    @Column(name = "chequeNumber", nullable = false)
    String chequeNumber;

    @Column(name = "chequeCode", nullable = false)
    String chequeCode;

    @Column(name = "transit", nullable = false)
    String transit;

    @Column(name = "financialInstitution", nullable = false)
    String financialInstitution;

    @Column(name = "designation", nullable = false)
    String designation;

    @Column(name = "bankName", nullable = false)
    String bankName;

    @Embedded
    @AttributeOverrides(value={
            @AttributeOverride(name = "bankAddressLine1", column = @Column(name = "bankHouseNumber", insertable = true, updatable = true, nullable = true, length = 5)),
            @AttributeOverride(name = "bankAddressLine2", column = @Column(name = "bankStreet", insertable = true, updatable = true, nullable = true)),
            @AttributeOverride(name = "bankAddressLine3", column = @Column(name = "bankZipCode", insertable = true, updatable = true, nullable = true, length = 7))
    })
    Bank bank;

}
