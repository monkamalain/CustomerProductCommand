package ca.tmas.cpc.service.impl;

import ca.tmas.cpc.repository.ChequePaymentRepository;
import ca.tmas.cpc.service.ChequePaymentService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Service
@EnableTransactionManagement
@Slf4j
public class ChequePaymentServiceImpl implements ChequePaymentService {

    private static final long CSTCQP;

    private static final String REFCQP;

    private ChequePaymentRepository chequePaymentRepository;

    private ModelMapper mapper;

    static {
        CSTCQP = 22222L;
        REFCQP = "cqp-";
    }

    ChequePaymentServiceImpl(ChequePaymentRepository chequePaymentRepository, ModelMapper mapper) {
        this.chequePaymentRepository = chequePaymentRepository;
        this.mapper = mapper;
    }

}
