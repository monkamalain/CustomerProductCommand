package ca.tmas.cpc.service.impl;

import ca.tmas.cpc.repository.VisaCardPaymentRepository;
import ca.tmas.cpc.service.VisaCardPaymentService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Service
@EnableTransactionManagement
@Slf4j
@Setter
public class VisaCardPaymentServiceImpl implements VisaCardPaymentService {

    private final static Long CSTVCP;

    private static final String REFVCP;

    private VisaCardPaymentRepository visaCardPaymentRepository;

    private ModelMapper mapper;

    static {
        CSTVCP = 1111L;
        REFVCP = "vcp-";
    }

}
