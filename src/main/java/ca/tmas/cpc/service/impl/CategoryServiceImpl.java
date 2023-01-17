package ca.tmas.cpc.service.impl;

import ca.tmas.cpc.repository.CategoryRepository;
import ca.tmas.cpc.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Service
@EnableTransactionManagement
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private static final long CSTCAT;

    private static final String REFCAT;

    private CategoryRepository categoryRepository;

    private ModelMapper mapper;

    static {
        CSTCAT = 33333L;
        REFCAT = "cat-";
    }

    CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper mapper) {
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
    }

}
