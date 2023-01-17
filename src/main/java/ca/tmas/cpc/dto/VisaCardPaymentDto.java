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
public class VisaCardPaymentDto {

    String refVisaCard;

    BigInteger cardNumberVisaCard;

    int codeCvcVisaCard;

    LocalDateTime expirationDateVisaCard;

    String bankNameVisaCard;

}
