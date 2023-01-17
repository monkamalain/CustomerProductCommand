package ca.tmas.cpc.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigInteger;
import java.time.LocalDateTime;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class CreditCardPaymentDto {

    String refCreditCard;

    BigInteger cardNumberCreditCard;

    int codeCvcCreditCard;

    LocalDateTime expirationDateCreditCard;

    String bankNameCreditCard;

}
