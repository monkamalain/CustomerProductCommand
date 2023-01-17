package ca.tmas.cpc.dto;

import ca.tmas.cpc.model.Customer;
import ca.tmas.cpc.model.Employee;
import ca.tmas.cpc.model.Facture;
import ca.tmas.cpc.utils.PaymentType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class PaymentDto {

    String refPayment;

    double amountPayment;

    LocalDateTime paymentDate;

    PaymentType paymentType;

    Customer customer;

    Employee employee;

    Facture facturePayment;

}
