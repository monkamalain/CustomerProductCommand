package ca.tmas.cpc.dto;

import ca.tmas.cpc.model.Command;
import ca.tmas.cpc.model.Employee;
import ca.tmas.cpc.model.Payment;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
public class FactureDto {

    String refFactureDto;

    int cashNumberDto;

    LocalDateTime factureDateDto;

    double totalFactureDto;

    double amountCollectedDto;

    double amountReimbursedDto;

    Payment paymentFacture;

    Employee employeeFacture;

    List<Command> commandListFacture;

}
