package ca.tmas.cpc.repository;

import ca.tmas.cpc.model.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureRepository extends JpaRepository<Facture, String> {
}
