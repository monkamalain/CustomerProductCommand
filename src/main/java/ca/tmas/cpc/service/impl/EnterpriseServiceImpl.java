package ca.tmas.cpc.service.impl;

import ca.tmas.cpc.repository.EnterpriseRepository;
import ca.tmas.cpc.service.EnterpriseService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Service
@EnableTransactionManagement
@Slf4j
@Setter
public class EnterpriseServiceImpl implements EnterpriseService {

    private static final long CSTENT;

    private static final String REFENT;

    private EnterpriseRepository enterpriseRepository;

    private ModelMapper mapper;

    static {
        CSTENT = 5555L;
        REFENT = "ent-";
    }

}
