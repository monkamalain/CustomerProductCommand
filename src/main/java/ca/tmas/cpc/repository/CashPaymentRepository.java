package ca.tmas.cpc.repository;

import ca.tmas.cpc.model.CashPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashPaymentRepository extends JpaRepository<CashPayment, String> {
}
