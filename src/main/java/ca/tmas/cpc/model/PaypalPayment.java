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
public class PaypalPayment extends Payment implements Serializable {

    static final long serialVersionUID = 1L;

    @Column(name = "refPaypal", nullable = false, unique = true)
    String refPaypal;

    @Column(name = "cardNumberPaypal", nullable = false, length = 16)
    BigInteger cardNumberPaypal;

    @Column(name = "codeCvcPaypal", nullable = false, length = 3)
    int codeCvcPaypal;

    @Column(name = "expirationDatePaypal", nullable = false)
    LocalDateTime expirationDatePaypal;

    @Column(name = "bankNamePaypal", nullable = false)
    String bankNamePaypal;

}
