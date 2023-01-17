package ca.tmas.cpc.service.impl;

import ca.tmas.cpc.dto.ProductDto;
import ca.tmas.cpc.exceptions.GlobalFailedException;
import ca.tmas.cpc.model.Product;
import ca.tmas.cpc.repository.ProductRepository;
import ca.tmas.cpc.service.ProductService;
import ca.tmas.cpc.utils.ProductStatus;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
@EnableTransactionManagement
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final static Long CSTPD;

    private static final String REFPD;

    private ProductRepository productRepository;

    private ModelMapper modelMapper;

    static {
        CSTPD = 222222L;
        REFPD = "pdt-";
    }

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    @Override
    public ProductDto createProduct(ProductDto productDto) throws GlobalFailedException {
        Product pd;
        String nextRef;
        if(productRepository.findAllRefProduct().isEmpty()) {
            nextRef = REFPD + Long.toHexString(Long.MAX_VALUE % CSTPD);
        } else {
            String lastRef = productRepository.findAllRefProduct().stream().map(x -> x.substring(4)).collect(Collectors.toSet()).stream().max(String::compareTo).get();
            Long lastValue = Long.valueOf(lastRef, 16) + 1;
            nextRef = REFPD + Long.toHexString(lastValue);
        }
        try {
            pd = modelMapper.map(productDto, Product.class);
            pd.setRefProduct(nextRef.toUpperCase());
            pd.setCreationDateProduct(LocalDateTime.parse(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            pd.setStateProduct(ProductStatus.AVAILABLE.name());
            return modelMapper.map(productRepository.save(pd), ProductDto.class);
        } catch(IllegalArgumentException ex) {
            throw new GlobalFailedException("Impossible to create and persist Product");
        }
    }

    @Override
    public Optional<ProductDto> getProductByRef(String ref) {
        Optional<Product> pd = productRepository.findProductByRef(ref);
        return Optional.ofNullable(modelMapper.map(pd, ProductDto.class));
    }

    @Transactional
    @Override
    public ProductDto patiallyUpdateProduct(String ref, ProductDto productDto) {
        if(productDto != null) {
            Product currentProduct = modelMapper.map(productDto, Product.class);
            Product dbProduct = productRepository.findProductByRef(productDto.getRefProduct()).get();
            dbProduct.setRefProduct(ref);
            modelMapper.getConfiguration().setSkipNullEnabled(true);
            modelMapper.map(currentProduct, dbProduct);
            Product updateProduct = productRepository.save(dbProduct);
            return (updateProduct != null)? modelMapper.map(updateProduct, ProductDto.class): null;
        }
        return null;
    }

    @Transactional
    @Override
    public ProductDto totalyUpdateProduct(String ref, ProductDto productDto) {
        if(productDto != null) {
            Product currentProduct = modelMapper.map(productDto, Product.class);
            currentProduct.setId(productRepository.findProductByRef(ref).get().getId());
            currentProduct.setRefProduct(productRepository.findProductByRef(ref).get().getRefProduct());
            Product updateProduct = productRepository.save(currentProduct);
            return (updateProduct != null)? modelMapper.map(updateProduct, ProductDto.class): null;
        }
        return null;
    }

    @Transactional
    @Override
    public Optional<ProductDto> deleteProductByRef(String ref) {
        if((productRepository.findProductByRef(ref).isPresent()) && (productRepository.findProductByRef(ref).get().getStateProduct().equals(ProductStatus.AVAILABLE.name()))) {
            Product pd = productRepository.findProductByRef(ref).get();
            pd.setDateSaleProduct(LocalDateTime.parse(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            pd.setStateProduct(ProductStatus.UNAVAILABLE.name());
            return Optional.of(modelMapper.map(pd, ProductDto.class));
        }
        return Optional.empty();
    }

    @Override
    public List<ProductDto> getAllProductsByStateAvailable(String state) {
        if (productRepository.countAllProductByStateAvailable(state) >= 1L) {
            List<ProductDto> productDtoList = new ArrayList<>();
            productRepository.findAllProductByStateAvailable(state).forEach(pd -> productDtoList.add(modelMapper.map(pd, ProductDto.class)));
            return productDtoList;
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public List<ProductDto> getAllProductsByStateUnavailable(String state) {
        if (productRepository.countAllProductByStateUnavailable(state) >= 1L) {
            List<ProductDto> productDtoList = new ArrayList<>();
            productRepository.findAllProductByStateUnavailable(state).forEach(pd -> productDtoList.add(modelMapper.map(pd, ProductDto.class)));
            return productDtoList;
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public Set<String> getAllRefProduct() {
        return (!productRepository.findAllRefProduct().isEmpty())? productRepository.findAllRefProduct(): Collections.emptySet();
    }

    @Override
    public List<ProductDto> getAllProduct() {
        if(productRepository.findAll().isEmpty()) {
            return Collections.emptyList();
        } else {
            List<ProductDto> productDtoList = new ArrayList<>();
            productRepository.findAll().forEach(pd -> productDtoList.add(modelMapper.map(pd, ProductDto.class)));
            return productDtoList;
        }
    }

    @Override
    public List<ProductDto> getProductByPrice(double price) {
        if (productRepository.findProductByPrice(price).isEmpty()) {
            return Collections.emptyList();
        } else {
            List<ProductDto> productDtoList = new ArrayList<>();
            productRepository.findProductByPrice(price).forEach(pd -> productDtoList.add(modelMapper.map(pd, ProductDto.class)));
            return productDtoList;
        }
    }

    @Override
    public List<ProductDto> getProductByPriceBetween(double price1, double price2) {
        if(productRepository.findProductByPriceBetween(price1, price2).isEmpty()) {
            return Collections.emptyList();
        } else {
            List<ProductDto> productDtoList = new ArrayList<>();
            productRepository.findProductByPriceBetween(price1, price2).forEach(pd -> productDtoList.add(modelMapper.map(pd, ProductDto.class)));
            return productDtoList;
        }
    }

    @Override
    public List<ProductDto> getProductByCreationDate(String creationDate) {
        LocalDateTime creationDateConvertToDateTime = LocalDateTime.parse(creationDate);
        if(productRepository.findProductByCreationDate(creationDateConvertToDateTime).isEmpty()) {
            return Collections.emptyList();
        } else {
            List<ProductDto> productDtoList = new ArrayList<>();
            productRepository.findProductByCreationDate(creationDateConvertToDateTime).forEach(pd -> productDtoList.add(modelMapper.map(pd, ProductDto.class)));
            return productDtoList;
        }
    }

    @Override
    public List<ProductDto> getProductBySaleDate(String saleDate) {
        LocalDateTime saleDateConvertToDateTime = LocalDateTime.parse(saleDate);
        if(productRepository.findProductBySaleDate(saleDateConvertToDateTime).isEmpty()) {
            return Collections.emptyList();
        } else {
            List<ProductDto> productDtoList = new ArrayList<>();
            productRepository.findProductBySaleDate(saleDateConvertToDateTime).forEach(pd -> productDtoList.add(modelMapper.map(pd, ProductDto.class)));
            return productDtoList;
        }
    }

    @Override
    public double getProductBySaleDateAndPrice(String saleDate1, String saleDate2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:00");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:59");
        LocalDateTime saleDateConvertToDateTime1 = LocalDateTime.parse(saleDate1, formatter);
        LocalDateTime saleDateConvertToDateTime2 = LocalDateTime.parse(saleDate2, formatter2);
        return (productRepository.findProductBySaleDateAndPrice(saleDateConvertToDateTime1, saleDateConvertToDateTime2) != 0.0d)? productRepository.findProductBySaleDateAndPrice(saleDateConvertToDateTime1, saleDateConvertToDateTime2) : 0.0d;
    }

}
