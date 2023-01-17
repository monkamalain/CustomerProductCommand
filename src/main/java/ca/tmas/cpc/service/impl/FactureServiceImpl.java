package ca.tmas.cpc.service.impl;

import ca.tmas.cpc.repository.FactureRepository;
import ca.tmas.cpc.service.FactureService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Service
@EnableTransactionManagement
@Slf4j
@Setter
public class FactureServiceImpl implements FactureService {

    private static final long CSTF;

    private static final String REFF;

    private FactureRepository factureRepository;

    private ModelMapper mapper;

    static {
        CSTF = 4444L;
        REFF = "fac-";
    }

}
