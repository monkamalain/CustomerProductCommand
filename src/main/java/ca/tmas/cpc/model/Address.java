package ca.tmas.cpc.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Embeddable;

@Embeddable
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Address {

    String addressLine1;

    String addressLine2;

    String addressLine3;

    String cityAddress;

    String countryAddress;

}
