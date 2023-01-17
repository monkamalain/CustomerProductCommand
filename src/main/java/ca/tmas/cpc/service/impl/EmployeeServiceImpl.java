package ca.tmas.cpc.service.impl;

import ca.tmas.cpc.repository.EmployeeRepository;
import ca.tmas.cpc.service.EmployeeService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Service
@EnableTransactionManagement
@Slf4j
@Setter
public class EmployeeServiceImpl implements EmployeeService {

    private static final long CSTEMP;

    private static final String REFEMP;

    private EmployeeRepository employeeRepository;

    private ModelMapper mapper;

    static {
        CSTEMP = 6666L;
        REFEMP = "emp-";
    }

}
