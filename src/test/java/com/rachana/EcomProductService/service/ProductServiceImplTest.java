package com.rachana.EcomProductService.service;


import com.rachana.EcomProductService.dto.response.ProductResponseDTO;
import com.rachana.EcomProductService.module.Category;
import com.rachana.EcomProductService.module.Price;
import com.rachana.EcomProductService.module.Product;
import com.rachana.EcomProductService.productException.InvalidTitleException;
import com.rachana.EcomProductService.productException.ProductNotFoundException;
import com.rachana.EcomProductService.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.when;

import java.util.UUID;

@SpringBootTest
public class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getProductByTitleTest() throws InvalidTitleException, ProductNotFoundException {
        /// create or Arrange

        Category category=new Category();
        category.setCategoryName("electronics");

        Price price=new Price();
        price.setAmt(100);

        String title="testProductTitle";
        Product mockProduct=new Product();
        mockProduct.setTitle(title);
        mockProduct.setDescription("Mock product test");
        mockProduct.setImage("www.com/productImage");
        mockProduct.setUuid(UUID.randomUUID());
        mockProduct.setCategory(category);
        mockProduct.setPrice(price);

        Product savedProduct = (Product) when(productRepository.findByTitle(title)).thenReturn(mockProduct);

        //call or act
        ProductResponseDTO productResponseDTO=productService.getProductByTitle(title);

        //check or assert
        Assertions.assertEquals(productResponseDTO.getTitle(),mockProduct.getTitle());
        Assertions.assertEquals(productResponseDTO.getDescription(),mockProduct.getDescription());
        Assertions.assertEquals(productResponseDTO.getImage(),mockProduct.getImage());
       // Assertions.assertEquals(productResponseDTO.getId(),mockProduct.getUuid());



    }

    @Test
    public void getProductByTitle_ResponseDTOWithNullObject() throws InvalidTitleException, ProductNotFoundException {
        String title="helloProduct";
        when(productRepository.findByTitle(title)).thenReturn(null);

        //call
        Assertions.assertThrows(ProductNotFoundException.class,()->productService.getProductByTitle(title));

    }
    @Test
    public void getProductByNullTitle(){
        String title= null;

        when(productRepository.findByTitle(title)).thenReturn(null);

        //call
        Assertions.assertThrows(InvalidTitleException.class,()->productService.getProductByTitle((title)));
    }
}
