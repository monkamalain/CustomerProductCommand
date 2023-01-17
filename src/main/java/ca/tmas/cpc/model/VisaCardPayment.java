package ca.tmas.cpc.model;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VisaCardPayment extends Payment implements Serializable {

    static final long serialVersionUID = 1L;

    @Column(name = "refVisaCard", nullable = false, unique = true)
    String refVisaCard;

    @Column(name = "cardNumberVisaCard", nullable = false, length = 16)
    BigInteger cardNumberVisaCard;

    @Column(name = "codeCvvVisaCard", nullable = false, length = 3)
    int codeCvcVisaCard;

    @Column(name = "expirationDateVisaCard", nullable = false)
    LocalDateTime expirationDateVisaCard;

    @Column(name = "bankNameVisaCard", nullable = false)
    String bankNameVisaCard;

}
