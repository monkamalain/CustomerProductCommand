package ca.tmas.cpc.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class BankDto {

    String bankAddressLine1;

    String bankAddressLine2;

    String bankAddressLine3;

    @NotNull
    String bankCity;

    @NotNull
    String bankCountry;

}
