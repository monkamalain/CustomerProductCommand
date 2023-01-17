package ca.tmas.cpc.dto;

import ca.tmas.cpc.model.Address;
import ca.tmas.cpc.model.Bank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class ChequePaymentDto {

    String refCheque;

    String nameCustomer;

    Address address;

    String chequeNumber;

    String chequeCode;

    String transit;

    String financialInstitution;

    String designation;

    String bankName;

    Bank bank;

}
