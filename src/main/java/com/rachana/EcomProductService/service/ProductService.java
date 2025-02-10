package com.rachana.EcomProductService.service;

import com.rachana.EcomProductService.dto.ProductResponseDTO;
import com.rachana.EcomProductService.dto.ProductResponseListDTO;

import java.util.List;

public interface ProductService {
  ProductResponseListDTO getAllProduct();
    ProductResponseDTO getProductById(int id);
    ProductResponseDTO updateProduct(int id,ProductResponseDTO product);
    ProductResponseDTO createProduct(ProductResponseDTO product);
    ProductResponseDTO deleteProduct(int id);

}
