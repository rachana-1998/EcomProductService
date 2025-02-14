package com.rachana.EcomProductService.mapper;

import com.rachana.EcomProductService.dto.FakeProductResponseDTO;
import com.rachana.EcomProductService.dto.FakeProductsRequestDTO;
import com.rachana.EcomProductService.dto.ProductRequestDTO;
import com.rachana.EcomProductService.dto.ProductResponseDTO;

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

}
