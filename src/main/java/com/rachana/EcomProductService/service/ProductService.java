package com.rachana.EcomProductService.service;

import com.rachana.EcomProductService.dto.ProductRequestDTO;
import com.rachana.EcomProductService.dto.ProductResponseDTO;
import com.rachana.EcomProductService.dto.ProductResponseListDTO;
import com.rachana.EcomProductService.productException.ProductException;

import java.util.List;

public interface ProductService {
  ProductResponseListDTO getAllProduct();
    ProductResponseDTO getProductById(int id) throws ProductException;
    ProductResponseDTO updateProduct(int id,ProductResponseDTO product);
    ProductResponseDTO createProduct(ProductRequestDTO product);
   boolean deleteProduct(int id);

}
