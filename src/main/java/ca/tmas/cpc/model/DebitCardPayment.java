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
@PrimaryKeyJoinColumn(name="id")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DebitCardPayment extends Payment implements Serializable {

    static final long serialVersionUID = 1L;

    @Column(name = "refDebitCard", nullable = false, unique = true)
    String refDebitCard;

    @Column(name = "cardNumberDebitCard", nullable = false, length = 16)
    BigInteger cardNumberDebitCard;

    @Column(name = "codeCvcDebitCard", nullable = false, length = 3)
    int codeCvcDebitCard;

    @Column(name = "expirationDateDebitCard", nullable = false)
    LocalDateTime expirationDateDebitCard;

    @Column(name = "bankNameDebitCard", nullable = false)
    String bankNameDebitCard;

}
