package com.springdemo.nobsv2;

import com.springdemo.nobsv2.exceptions.ProductNotFoundException;
import com.springdemo.nobsv2.product.model.Product;
import com.springdemo.nobsv2.product.model.ProductDTO;
import com.springdemo.nobsv2.product.services.GetProductService;
import com.springdemo.nobsv2.product.validators.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import javax.swing.plaf.PanelUI;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class GetProductServiceTest {

    @Mock //What to mock the resposne of - > need this depenedcy to run the test
    private ProductRepository productRepository;

    @InjectMocks //Thing that are tested
    private GetProductService getProductService;

    @BeforeEach //Things needed before the test runs to set up properly
    public void setup(){
        //initializes the repository & the service
        MockitoAnnotations.openMocks(this);

    }
    @Test
    public void given_product_exists_when_get_product_service_return_product_dto(){
        //Given
        Product product = new Product();
        product.setId(1);
        product.setName("Product Name");
        product.setDescription("Product description must be at least 20 chars, which is");
        product.setPrice(9.99);

        when(productRepository.findById(1)).thenReturn(Optional.of(product));
        //When
        ResponseEntity<ProductDTO> response = getProductService.execute(1);

        //then
        assertEquals(ResponseEntity.ok(new ProductDTO(product)), response);
        //aserts the product repository was only called once
        verify(productRepository,times(1)).findById(1);
    }
    @Test
    public void given_product_does_not_exist_when_get_product_service_throw_product_not_found_exception(){
        //given
        when(productRepository.findById(1)).thenReturn(Optional.empty());
        //when & then
        assertThrows(ProductNotFoundException.class, () -> getProductService.execute(1));
        verify(productRepository,times(1)).findById(1);
    }
}