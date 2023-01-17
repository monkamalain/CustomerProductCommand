package ca.tmas.cpc.service.impl;

import ca.tmas.cpc.repository.PaymentRepository;
import ca.tmas.cpc.service.PaymentService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Service
@EnableTransactionManagement
@Slf4j
@Setter
public class PaymentServiceImpl implements PaymentService {

    private static final long CSTP;

    private static final String REFP;

    private PaymentRepository paymentRepository;

    private ModelMapper mapper;

    static {
        CSTP = 3333L;
        REFP = "pay-";
    }

}
