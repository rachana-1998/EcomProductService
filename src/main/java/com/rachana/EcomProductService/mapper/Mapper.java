package com.rachana.EcomProductService.mapper;

import com.rachana.EcomProductService.dto.*;
import com.rachana.EcomProductService.module.Product;

import java.util.List;

public class Mapper {

    public static FakeProductsRequestDTO productRequestTofakeproduct(ProductRequestDTO productRequestDTO){
        FakeProductsRequestDTO fakeProductsRequestDTO=new FakeProductsRequestDTO();
        fakeProductsRequestDTO.setTitle(productRequestDTO.getTitle());
        fakeProductsRequestDTO.setCategory(productRequestDTO.getCategory());
        fakeProductsRequestDTO.setImage(productRequestDTO.getImage());
        fakeProductsRequestDTO.setPrice(productRequestDTO.getPrice());
        fakeProductsRequestDTO.setDescription(productRequestDTO.getDescription());
        return  fakeProductsRequestDTO;
    }


    public static ProductResponseDTO fakeProductResponseToProductResponse(FakeProductResponseDTO fakeProductResponseDTO){
        ProductResponseDTO productResponseDTO=new ProductResponseDTO();
        productResponseDTO.setId(fakeProductResponseDTO.getId());
        productResponseDTO.setPrice(fakeProductResponseDTO.getPrice());
        productResponseDTO.setImage(fakeProductResponseDTO.getImage());
        productResponseDTO.setTitle(fakeProductResponseDTO.getTitle());
        productResponseDTO.setCategory(fakeProductResponseDTO.getCategory());
        productResponseDTO.setDescription(fakeProductResponseDTO.getDescription());
        return productResponseDTO;
    }
    public  static ProductResponseListDTO productToProductResponseDTO(List<Product> products){
        ProductResponseListDTO productResponseListDTO=new ProductResponseListDTO();
        for(Product p:products){
            ProductResponseDTO   responseDTO=new ProductResponseDTO();
            responseDTO.setId(p.getUuid());
            responseDTO.setDescription(p.getDescription());
            responseDTO.setCategory(p.getCategory().getCategoryName());
            responseDTO.setImage(p.getImage());
            responseDTO.setPrice(p.getPrice().getAmt());
            responseDTO.setTitle(p.getTitle());
            productResponseListDTO.getProducts().add(responseDTO);

        }
        return  productResponseListDTO;
    }
    public  static  ProductResponseDTO productToResponceDTO(Product product){
        ProductResponseDTO productResponseDTO=new ProductResponseDTO();
        productResponseDTO.setTitle(product.getTitle());
        productResponseDTO.setDescription(product.getDescription());
        productResponseDTO.setCategory(product.getCategory().getCategoryName());
        productResponseDTO.setImage(product.getImage());
        productResponseDTO.setPrice(product.getPrice().getAmt());
        productResponseDTO.setId(product.getUuid());
        return  productResponseDTO;
    }

}
