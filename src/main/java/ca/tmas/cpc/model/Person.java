package ca.tmas.cpc.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person extends EntityWithUUID implements Serializable {

    static final long serialVersionUID = 1L;

    @Column(name = "firstName", nullable = true)
    String firstName;

    @Column(name = "lastName", nullable = true)
    String lastName;

    @Embedded
    @AttributeOverrides(value={
            @AttributeOverride(name = "addressLine1", column = @Column(name = "houseNumber", insertable = true, updatable = true, nullable = true, length = 5)),
            @AttributeOverride(name = "addressLine2", column = @Column(name = "street", insertable = true, updatable = true, nullable = true)),
            @AttributeOverride(name = "addressLine3", column = @Column(name = "zipCode", insertable = true, updatable = true, nullable = true, length = 7))
    })
    Address address;

}
