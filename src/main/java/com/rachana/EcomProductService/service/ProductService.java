package com.rachana.EcomProductService.service;

import com.rachana.EcomProductService.dto.request.ProductRequestDTO;
import com.rachana.EcomProductService.dto.response.ProductResponseDTO;
import com.rachana.EcomProductService.dto.response.ProductResponseListDTO;
import com.rachana.EcomProductService.productException.InvalidTitleException;
import com.rachana.EcomProductService.productException.ProductNotFoundException;

import java.util.UUID;

public interface ProductService {
  ProductResponseListDTO getAllProduct();
    ProductResponseDTO getProductById(UUID id) throws ProductNotFoundException;
    ProductResponseDTO updateProduct(UUID id,ProductRequestDTO product);
    ProductResponseDTO createProduct(ProductRequestDTO product);
   boolean deleteProduct(UUID id);
   ProductResponseDTO getProductByTitle(String title) throws InvalidTitleException, ProductNotFoundException;

}
