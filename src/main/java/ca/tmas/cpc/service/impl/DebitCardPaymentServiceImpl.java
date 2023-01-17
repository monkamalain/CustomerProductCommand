package ca.tmas.cpc.service.impl;

import ca.tmas.cpc.repository.DebitCardPaymentRepository;
import ca.tmas.cpc.service.DebitCardPaymentService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Service
@EnableTransactionManagement
@Slf4j
@Setter
public class DebitCardPaymentServiceImpl implements DebitCardPaymentService {

    private static final long CSTDCD;

    private static final String REFDCD;

    private DebitCardPaymentRepository debitCardPaymentRepository;

    private ModelMapper mapper;

    static {
        CSTDCD = 7777L;
        REFDCD = "dcd-";
    }

}
