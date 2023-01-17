package ca.tmas.cpc.dto;

import ca.tmas.cpc.model.Payment;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class CustomerDto {

    String refCostumer;

    List<Payment> paymentListCustomer;

}
