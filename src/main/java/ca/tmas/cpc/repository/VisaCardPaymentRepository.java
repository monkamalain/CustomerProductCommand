package ca.tmas.cpc.repository;

import ca.tmas.cpc.model.VisaCardPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisaCardPaymentRepository extends JpaRepository<VisaCardPayment, String> {
}
