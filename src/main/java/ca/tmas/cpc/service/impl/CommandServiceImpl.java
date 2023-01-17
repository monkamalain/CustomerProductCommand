package ca.tmas.cpc.service.impl;

import ca.tmas.cpc.repository.CommandRepository;
import ca.tmas.cpc.service.CommandService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Service
@EnableTransactionManagement
@Slf4j
public class CommandServiceImpl implements CommandService {

    private static final long CSTCMD;

    private static final String REFCMD;

    private CommandRepository commandRepository;

    private ModelMapper mapper;

    static {
        CSTCMD = 11111L;
        REFCMD = "cmd-";
    }

    CommandServiceImpl(CommandRepository commandRepository, ModelMapper mapper) {
        this.commandRepository = commandRepository;
        this.mapper = mapper;
    }

}
