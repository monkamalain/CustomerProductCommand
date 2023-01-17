package ca.tmas.cpc.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class AddressDto {

    String addressLine1;

    String addressLine2;

    String addressLine3;

    @NotNull
    String city;

    @NotNull
    String country;
}
