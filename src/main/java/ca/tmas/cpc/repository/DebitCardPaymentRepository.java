package ca.tmas.cpc.repository;

import ca.tmas.cpc.model.DebitCardPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DebitCardPaymentRepository extends JpaRepository<DebitCardPayment, String> {
}
