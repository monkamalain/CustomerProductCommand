package ca.tmas.cpc.service;

import ca.tmas.cpc.dto.ProductDto;
import ca.tmas.cpc.exceptions.GlobalFailedException;
import ca.tmas.cpc.model.Product;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ProductService {

    public ProductDto createProduct(ProductDto productDto) throws GlobalFailedException;

    public Optional<ProductDto> getProductByRef(String ref);

    public ProductDto patiallyUpdateProduct(String ref, ProductDto productDto);

    public ProductDto totalyUpdateProduct(String ref, ProductDto productDto);

    public Optional<ProductDto> deleteProductByRef(String ref);

    public List<ProductDto> getAllProductsByStateAvailable(String state);

    public List<ProductDto> getAllProductsByStateUnavailable(String state);

    public Set<String> getAllRefProduct();

    public List<ProductDto> getAllProduct();

    public List<ProductDto> getProductByPrice(double price);

    public List<ProductDto> getProductByPriceBetween(double price1, double price2);

    public List<ProductDto> getProductByCreationDate(String creationDate);

    public List<ProductDto> getProductBySaleDate(String saleDate);

    public double getProductBySaleDateAndPrice(String saleDate1, String saleDate2);

}
