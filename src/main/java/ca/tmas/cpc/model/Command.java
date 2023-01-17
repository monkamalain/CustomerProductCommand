package ca.tmas.cpc.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Command extends EntityWithUUID implements Serializable {

    static final long serialVersionUID = 1L;

    @Column(name = "refCommand", nullable = false, unique = true)
    String refCommand;

    @Column(name = "categoryCommand", nullable = false)
    String categoryCommand;

    @Column(name = "descriptionCommand", nullable = false)
    String descriptionCommand;

    @Column(name = "sousTotalCommand", nullable = false)
    double sousTotalCommand;

    @Column(name = "itemNumber", nullable = false, length = 3)
    int itemNumber;

    @ManyToOne
    Facture factureCommand;

    @OneToMany(targetEntity = Category.class, mappedBy = "commandCategory")
    List<Category> productList = new ArrayList<>();

}
