package com.rachana.EcomProductService.controller;

import com.rachana.EcomProductService.dto.ProductResponseDTO;
import com.rachana.EcomProductService.dto.ProductResponseListDTO;
import com.rachana.EcomProductService.service.FakeProductServiceImpl;
import com.rachana.EcomProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ProductController {


@Autowired
@Qualifier("fakeproductservice")
    ProductService productService;

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(){
        ProductResponseDTO productResponseDTO= productService.getProductById(1);
        return ResponseEntity.ok(productResponseDTO);


    }
}
