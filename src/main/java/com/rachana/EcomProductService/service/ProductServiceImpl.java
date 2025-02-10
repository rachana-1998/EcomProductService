package com.rachana.EcomProductService.service;

import com.rachana.EcomProductService.dto.ProductResponseDTO;
import com.rachana.EcomProductService.dto.ProductResponseListDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("productservice")
public class ProductServiceImpl implements ProductService {

    @Override
    public ProductResponseListDTO getAllProduct() {
        return null;
    }

    @Override
    public ProductResponseDTO getProductById(int id) {
        return null;
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
