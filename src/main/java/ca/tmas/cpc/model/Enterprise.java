package ca.tmas.cpc.model;

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
public class Enterprise extends EntityWithUUID implements Serializable {

    static final long serialVersionUID = 1L;

    @Column(name = "refEnterprise", nullable = false, unique = true)
    String refEnterprise;

    @Column(name = "enterpriseName", nullable = false)
    String enterpriseName;

    @Embedded
    @AttributeOverrides(value={
            @AttributeOverride(name = "addressLine1", column = @Column(name = "houseNumber", insertable = true, updatable = true, nullable = true, length = 5)),
            @AttributeOverride(name = "addressLine2", column = @Column(name = "street", insertable = true, updatable = true, nullable = true)),
            @AttributeOverride(name = "addressLine3", column = @Column(name = "zipCode", insertable = true, updatable = true, nullable = true, length = 7))
    })
    Address address;

    @Column(name = "phoneNumber", nullable = false)
    String phoneNumber;

    @OneToMany(targetEntity = Employee.class, mappedBy = "enterprise")
    List<Employee> employeeList = new ArrayList<>();

}
