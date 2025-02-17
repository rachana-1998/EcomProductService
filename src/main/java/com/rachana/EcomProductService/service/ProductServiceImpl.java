package com.rachana.EcomProductService.service;

import com.rachana.EcomProductService.dto.ProductRequestDTO;
import com.rachana.EcomProductService.dto.ProductResponseDTO;
import com.rachana.EcomProductService.dto.ProductResponseListDTO;
import com.rachana.EcomProductService.mapper.Mapper;
import com.rachana.EcomProductService.module.Product;
import com.rachana.EcomProductService.productException.InvalidTitleException;
import com.rachana.EcomProductService.productException.ProductException;
import com.rachana.EcomProductService.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("productservice")
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    @Override
    public ProductResponseListDTO getAllProduct() {
            List< Product> products = productRepository.findAll();
        return Mapper.productToProductResponseDTO(products);
    }
    @Override
    public ProductResponseDTO getProductById(UUID id) {
//        Product product= productRepository.findById(id);
//        ProductResponseDTO productResponseDTO= Mapper.productToResponseDTO(product);
        return null;
    }

    @Override
    public ProductResponseDTO getProductByTitle(String title) throws InvalidTitleException, ProductException {
        if(title==null||title.isEmpty() ) {
        throw new InvalidTitleException("title is empty or null");
        }
        Product product= productRepository.findByTitle(title);
        if (product == null){
            throw new ProductException("Do not have product with given title");
        }

        return Mapper.productToResponceDTO(product);
    }

    @Override
    public ProductResponseDTO updateProduct(int id, ProductResponseDTO product) {
        return null;
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO product) {
        return null;
    }

    @Override
    public  boolean deleteProduct(int id) {
return  true;
    }
}
