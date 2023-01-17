package ca.tmas.cpc.service.impl;

import ca.tmas.cpc.repository.CustomerRepository;
import ca.tmas.cpc.service.CustomerService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Service
@EnableTransactionManagement
@Slf4j
@Setter
public class CustomerServiceImpl implements CustomerService {

    private static final long CSTCUS;

    private static final String REFCUS;

    private CustomerRepository customerRepository;

    private ModelMapper mapper;

    static {
        CSTCUS = 8888L;
        REFCUS = "cus-";
    }

}
