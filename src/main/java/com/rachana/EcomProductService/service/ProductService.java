package com.rachana.EcomProductService.service;

import com.rachana.EcomProductService.dto.ProductRequestDTO;
import com.rachana.EcomProductService.dto.ProductResponseDTO;
import com.rachana.EcomProductService.dto.ProductResponseListDTO;
import com.rachana.EcomProductService.productException.InvalidTitleException;
import com.rachana.EcomProductService.productException.ProductException;

import java.util.List;
import java.util.UUID;

public interface ProductService {
  ProductResponseListDTO getAllProduct();
    ProductResponseDTO getProductById(UUID id) throws ProductException;
    ProductResponseDTO updateProduct(int id,ProductResponseDTO product);
    ProductResponseDTO createProduct(ProductRequestDTO product);
   boolean deleteProduct(int id);
   ProductResponseDTO getProductByTitle(String title) throws InvalidTitleException, ProductException;

}
