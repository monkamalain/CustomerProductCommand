package ca.tmas.cpc.service.impl;

import ca.tmas.cpc.repository.PaypalPaymentRepository;
import ca.tmas.cpc.service.PaypalPaymentService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Service
@EnableTransactionManagement
@Slf4j
@Setter
public class PaypalPaymentServiceImpl implements PaypalPaymentService {

    private final static Long CSTPPP;

    private static final String REFPPP;

    private PaypalPaymentRepository paypalPaymentRepository;

    private ModelMapper mapper;

    static {
        CSTPPP = 2222L;
        REFPPP = "ppp-";
    }

}
