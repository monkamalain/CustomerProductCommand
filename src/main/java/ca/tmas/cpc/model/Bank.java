package ca.tmas.cpc.model;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Bank {

    String bankAddressLine1;

    String bankAddressLine2;

    String bankAddressLine3;

    String bankCity;

    String bankCountry;

}
