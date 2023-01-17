package ca.tmas.cpc.repository;

import ca.tmas.cpc.model.ChequePayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChequePaymentRepository extends JpaRepository<ChequePayment, String> {
}
