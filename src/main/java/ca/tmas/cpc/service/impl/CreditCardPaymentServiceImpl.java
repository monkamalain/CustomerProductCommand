package ca.tmas.cpc.service.impl;

import ca.tmas.cpc.repository.CreditCardPaymentRepository;
import ca.tmas.cpc.service.CreditCardPaymentService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Service
@EnableTransactionManagement
@Slf4j
@Setter
public class CreditCardPaymentServiceImpl implements CreditCardPaymentService {

    private static final long CSTCCP;

    private static final String REFCCP;

    private CreditCardPaymentRepository creditCardPaymentRepository;

    private ModelMapper mapper;

    static {
        CSTCCP = 9999L;
        REFCCP = "ccp-";
    }

}
