package ca.tmas.cpc.repository;

import ca.tmas.cpc.model.PaypalPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaypalPaymentRepository extends JpaRepository<PaypalPayment, String> {
}
