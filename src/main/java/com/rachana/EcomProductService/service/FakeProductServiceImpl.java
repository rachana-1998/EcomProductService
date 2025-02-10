package com.rachana.EcomProductService.service;

import com.rachana.EcomProductService.dto.ProductResponseDTO;
import com.rachana.EcomProductService.dto.ProductResponseListDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service("fakeproductservice")
public class FakeProductServiceImpl implements ProductService{

   private RestTemplateBuilder restTemplateBuilder;

    public FakeProductServiceImpl(RestTemplateBuilder restTemplateBuilder) {
         this.restTemplateBuilder=restTemplateBuilder;
    }
    @Override
    public ProductResponseListDTO getAllProduct() {
//        String url="https://fakestoreapi.com/products/1";
//        RestTemplate restTemplate=restTemplateBuilder.build();
//        ResponseEntity<ProductResponseListDTO> list=
//                restTemplate.getForEntity(url, ProductResponseListDTO.class);
        return null;
    }

    @Override
    public ProductResponseDTO getProductById(int id) {
        String url="https://fakestoreapi.com/products/"+id;
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<ProductResponseDTO>product=restTemplate.getForEntity(url,ProductResponseDTO.class);
        return product.getBody();
    }

    @Override
    public ProductResponseDTO updateProduct(int id, ProductResponseDTO product) {
        return null;
    }

    @Override
    public ProductResponseDTO createProduct(ProductResponseDTO product) {
        return null;
    }

    @Override
    public ProductResponseDTO deleteProduct(int id) {
        return null;
    }
}
