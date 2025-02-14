package com.rachana.EcomProductService.service;

import com.rachana.EcomProductService.client.FakeStoreProductClient;
import com.rachana.EcomProductService.dto.*;
import com.rachana.EcomProductService.productException.ProductException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.rachana.EcomProductService.mapper.Mapper.fakeProductResponseToProductResponse;
import static com.rachana.EcomProductService.mapper.Mapper.productRequestTofakeproduct;
import static com.rachana.EcomProductService.util.ProductUtil.isNull;
import com.rachana.EcomProductService.productException.ProductException;

import java.util.ArrayList;
import java.util.List;

@Service("fakeproductservice")
public class FakeProductServiceImpl implements ProductService{

   private RestTemplateBuilder restTemplateBuilder;
   private FakeStoreProductClient fakeStoreProductClient;

    public FakeProductServiceImpl(RestTemplateBuilder restTemplateBuilder, FakeStoreProductClient fakeStoreProductClient) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreProductClient = fakeStoreProductClient;
    }

    @Override
    public ProductResponseListDTO getAllProduct() {
        List<FakeProductResponseDTO> fakeProductResponseDTOS=fakeStoreProductClient.getAllProduct();
         ProductResponseListDTO productResponseListDTO=new ProductResponseListDTO();
        for(FakeProductResponseDTO product:fakeProductResponseDTOS){
             productResponseListDTO.getProducts().add(fakeProductResponseToProductResponse(product));
        }
        return productResponseListDTO;
    }

    @Override
    public ProductResponseDTO getProductById(int id) throws ProductException {
        FakeProductResponseDTO fakeProductResponseDTO=fakeStoreProductClient.getProductById(id);
        if(!(isNull(fakeProductResponseDTO))){
        ProductResponseDTO productResponseDTO=fakeProductResponseToProductResponse(fakeProductResponseDTO);
            return  productResponseDTO;
        }
        throw new ProductException("product not found with id :"+id);

    }

    @Override
    public ProductResponseDTO updateProduct(int id, ProductResponseDTO product) {
        return null;
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO product) {
       FakeProductsRequestDTO fakeProductsRequestDTO= productRequestTofakeproduct(product);
       FakeProductResponseDTO fakeProductResponseDTOResponseEntity = fakeStoreProductClient.createProduct(fakeProductsRequestDTO);
             return  fakeProductResponseToProductResponse(fakeProductResponseDTOResponseEntity);
    }

    @Override
    public boolean deleteProduct(int id) {
        String url="https://fakestoreapi.com/products/"+id;
        RestTemplate restTemplate=restTemplateBuilder.build();
        restTemplate.delete(url) ;
         return true;
    }
}
