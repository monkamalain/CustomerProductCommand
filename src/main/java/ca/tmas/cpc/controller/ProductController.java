package ca.tmas.cpc.controller;

import ca.tmas.cpc.dto.ProductDto;
import ca.tmas.cpc.exceptions.GlobalFailedException;
import ca.tmas.cpc.service.ProductService;
import ca.tmas.cpc.utils.ProductStatus;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(value = "/products")
@Slf4j
@Setter
public class ProductController {

    private ProductService productService;


    @RequestMapping(value = "/createProduct", method = RequestMethod.POST)
    synchronized public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto productDto) {
        try{
            return new ResponseEntity<ProductDto>(productService.createProduct(productDto), HttpStatus.CREATED);
        } catch(GlobalFailedException ex) {
            System.err.println(ex.getMessage());
            return new ResponseEntity<ProductDto>(HttpStatus.NOT_MODIFIED);
        }
    }

    @RequestMapping(value = "/getProductByRef/{ref}", method = RequestMethod.GET)
    synchronized public ResponseEntity<Optional<ProductDto>> getProductByRef(@PathVariable(value = "ref", required = true) String ref) {
        if(productService.getProductByRef(ref).isPresent()) {
            return new ResponseEntity<Optional<ProductDto>>(productService.getProductByRef(ref), HttpStatus.OK);
        } else {
            return new ResponseEntity<Optional<ProductDto>>(Optional.empty(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/patchProduct/{ref}", method = RequestMethod.PATCH)
    synchronized public ResponseEntity<ProductDto> patiallyUpdateProduct(@PathVariable(value = "ref", required = true) String ref, @Valid @RequestBody ProductDto productDto) {
        if((productService.getProductByRef(productDto.getRefProduct()).isPresent())) {
            return new ResponseEntity<ProductDto>(productService.patiallyUpdateProduct(ref, productDto), HttpStatus.OK);
        } else {
            return new ResponseEntity<ProductDto>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/putProduct/{ref}", method = RequestMethod.PUT)
    synchronized public ResponseEntity<ProductDto> totalyUpdateProduct(@PathVariable(value = "ref", required = true) String ref, @Valid @RequestBody ProductDto productDto) {
        if((productService.getProductByRef(productDto.getRefProduct()).isPresent()) && (productDto.getStateProduct().equals(ProductStatus.UNAVAILABLE.name()))) {
            return new ResponseEntity<ProductDto>(productService.totalyUpdateProduct(ref, productDto), HttpStatus.OK);
        } else {
            System.out.println("Je ne peux etre modifie");
            return new ResponseEntity<ProductDto>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/deleteProductByRef/{ref}", method = RequestMethod.DELETE)
    synchronized public ResponseEntity<Optional<ProductDto>> deleteProductByRef(@PathVariable(value = "ref", required = true) String ref) {
        if(productService.deleteProductByRef(ref).isPresent()) {
            return new ResponseEntity<Optional<ProductDto>>(productService.deleteProductByRef(ref), HttpStatus.OK);
        } else {
            return new ResponseEntity<Optional<ProductDto>>(Optional.empty(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/getAllProductsAvailables/{state}", method = RequestMethod.GET)
    synchronized public ResponseEntity<List<ProductDto>> getAllProductsAvailable(@PathVariable(value = "state", required = true) String state) {
        state = state.toUpperCase();
        if(state.equals(ProductStatus.AVAILABLE.name())) {
            return new ResponseEntity<List<ProductDto>>(productService.getAllProductsByStateAvailable(state), HttpStatus.OK);
        } else {
            return new ResponseEntity<List<ProductDto>>(Collections.emptyList(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/getAllProductsUnavailables/{state}", method = RequestMethod.GET)
    synchronized public ResponseEntity<List<ProductDto>> getAllProductsUnavailable(@PathVariable(value = "state", required = true) String state) {
        state = state.toUpperCase();
        if(state.equals(ProductStatus.UNAVAILABLE.name())) {
            return new ResponseEntity<List<ProductDto>>(productService.getAllProductsByStateUnavailable(state), HttpStatus.OK);
        } else {
            return new ResponseEntity<List<ProductDto>>(Collections.emptyList(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/getAllRefProduct", method = RequestMethod.GET)
    synchronized public ResponseEntity<Set<String>> getAllRefProduct() {
        if(productService.getAllRefProduct().isEmpty()) {
            return new ResponseEntity<Set<String>>(Collections.emptySet(), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Set<String>>(productService.getAllRefProduct(), HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/getAllProduct", method = RequestMethod.GET)
    synchronized public ResponseEntity<List<ProductDto>> getAllProduct() {
        if(productService.getAllProduct().isEmpty()) {
            return new ResponseEntity<List<ProductDto>>(Collections.emptyList(), HttpStatus.NOT_FOUND);
        } else{
            return new ResponseEntity<List<ProductDto>>(productService.getAllProduct(), HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/getProductByPrice/{price}", method = RequestMethod.GET)
    synchronized public ResponseEntity<List<ProductDto>> getProductByPrice(@PathVariable(value = "price", required = true) double price) {
        if(productService.getProductByPrice(price).isEmpty()) {
            return new ResponseEntity<List<ProductDto>>(Collections.emptyList(), HttpStatus.NOT_FOUND);
        } else{
            return new ResponseEntity<List<ProductDto>>(productService.getProductByPrice(price), HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/getProductByPriceBetween/{price1}/{price2}", method = RequestMethod.GET)
    synchronized public ResponseEntity<List<ProductDto>> getProductByPriceBetween(@PathVariable(value = "price1", required = true) double price1, @PathVariable(value = "price2", required = true) double price2) {
        if((productService.getProductByPriceBetween(price1, price2).isEmpty()) && (price1 >= price2)){
            return new ResponseEntity<List<ProductDto>>(Collections.emptyList(), HttpStatus.NOT_FOUND);
        } else{
            return new ResponseEntity<List<ProductDto>>(productService.getProductByPriceBetween(price1, price2), HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/getProductByCreationDate/{creationDate}", method = RequestMethod.GET)
    synchronized public ResponseEntity<List<ProductDto>> getProductByCreationDate(@PathVariable(value = "creationDate", required = true) String creationDate) {
        if(productService.getProductByCreationDate(creationDate).isEmpty()){
            return new ResponseEntity<List<ProductDto>>(Collections.emptyList(), HttpStatus.NOT_FOUND);
        } else{
            return new ResponseEntity<List<ProductDto>>(productService.getProductByCreationDate(creationDate), HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/getProductBySaleDate/{saleDate}", method = RequestMethod.GET)
    synchronized public ResponseEntity<List<ProductDto>> getProductBySaleDate(@PathVariable(value = "saleDate", required = true) String saleDate) {
        if(productService.getProductBySaleDate(saleDate).isEmpty()){
            return new ResponseEntity<List<ProductDto>>(Collections.emptyList(), HttpStatus.NOT_FOUND);
        } else{
            return new ResponseEntity<List<ProductDto>>(productService.getProductBySaleDate(saleDate), HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/getProductBySaleDateAndPrice/{saleDate1}/{saleDate2}", method = RequestMethod.GET)
    synchronized public ResponseEntity<Double> getProductBySaleDateAndPrice(@PathVariable(value = "saleDate1", required = true) String saleDate1, @PathVariable(value = "saleDate2", required = true) String saleDate2) {
        if(productService.getProductBySaleDateAndPrice(saleDate1, saleDate2) == 0.0d){
            return new ResponseEntity<Double>(0.0d, HttpStatus.NOT_FOUND);
        } else{
            return new ResponseEntity<Double>(productService.getProductBySaleDateAndPrice(saleDate1, saleDate2), HttpStatus.OK);
        }
    }

}
