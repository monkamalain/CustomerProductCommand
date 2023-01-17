package ca.tmas.cpc.dto;

import ca.tmas.cpc.model.Facture;
import ca.tmas.cpc.model.Product;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
public class CommandDto {

    String refCommand;

    String categoryCommand;

    String descriptionCommand;

    double sousTotalCommand;

    int itemNumber;

    Facture factureCommand;

    List<Product> productList;

}
