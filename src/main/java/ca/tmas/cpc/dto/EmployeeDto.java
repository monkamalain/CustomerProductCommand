package ca.tmas.cpc.dto;

import ca.tmas.cpc.model.Enterprise;
import ca.tmas.cpc.model.Facture;
import ca.tmas.cpc.model.Payment;
import ca.tmas.cpc.utils.MatrimonialStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class EmployeeDto {

    String refEmployee;

    String gender;

    int age;

    MatrimonialStatus matrimonialStatus;

    String nas;

    Byte[] picture;

    Enterprise enterprise;

    List<Payment> paymentListEmployee;

    List<Facture> factureList;

}
