package ca.tmas.cpc.service.impl;

import ca.tmas.cpc.repository.CashPaymentRepository;
import ca.tmas.cpc.service.CashPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Service
@EnableTransactionManagement
@Slf4j
public class CashPaymentServiceImpl implements CashPaymentService {

    private static final long CSTCAP;

    private static final String REFCAP;

    private CashPaymentRepository cashPaymentRepository;

    private ModelMapper mapper;

    static {
        CSTCAP = 44444L;
        REFCAP = "cap-";
    }

    CashPaymentServiceImpl(CashPaymentRepository cashPaymentRepository, ModelMapper mapper) {
        this.cashPaymentRepository = cashPaymentRepository;
        this.mapper = mapper;
    }

}
