package ca.tmas.cpc.mapstruct;

import ca.tmas.cpc.dto.FactureDto;
import ca.tmas.cpc.model.Facture;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {Facture.class}, componentModel = "spring")
public interface FactureMapper {

    FactureMapper FACTURE_MAPPER = Mappers.getMapper(FactureMapper.class);

    public abstract FactureDto fromCreate(Facture facture);

    @Mappings(value = {
            @Mapping(source = "refFactureDto", target = "refFacture"),
            @Mapping(source = "cashNumberDto", target = "cashNumber"),
            @Mapping(source = "factureDateDto", target = "factureDate"),
            @Mapping(source = "totalFactureDto", target = "totalFacture"),
            @Mapping(source = "amountCollectedDto", target = "amountCollected"),
            @Mapping(source = "amountReimbursedDto", target = "amountReimbursed")
    })
    public abstract Facture fromPatiallyAndTotalyUpdate(FactureDto productDto);

    public abstract List<FactureDto> from(List<Facture> productList);
}
