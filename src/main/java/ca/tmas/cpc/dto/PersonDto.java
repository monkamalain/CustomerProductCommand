package ca.tmas.cpc.dto;

import ca.tmas.cpc.model.Address;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class PersonDto {

    String firstName;

    String lastName;

    Address address;

}
