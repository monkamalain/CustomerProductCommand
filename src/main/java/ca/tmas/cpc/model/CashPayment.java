package ca.tmas.cpc.model;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.io.Serializable;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CashPayment extends Payment implements Serializable {

    static final long serialVersionUID = 1L;

    @Column(name = "refCash", nullable = false, unique = true)
    String refCash;

    @Column(name = "devise", nullable = false)
    String devise;

}
