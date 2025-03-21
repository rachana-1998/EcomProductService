package com.rachana.EcomProductService.service;

import com.fasterxml.jackson.databind.deser.Deserializers;
import com.rachana.EcomProductService.dto.request.ProductRequestDTO;
import com.rachana.EcomProductService.dto.response.ProductResponseDTO;
import com.rachana.EcomProductService.dto.response.ProductResponseListDTO;
import com.rachana.EcomProductService.mapper.ProductMapper;
import com.rachana.EcomProductService.module.Product;
import com.rachana.EcomProductService.productException.InvalidTitleException;
import com.rachana.EcomProductService.productException.ProductNotFoundException;
import com.rachana.EcomProductService.repository.ProductRepository;
import org.apache.catalina.mapper.Mapper;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("productservice")
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final RedisTemplate<String,ProductResponseDTO> redisTemplate;

    public ProductServiceImpl(ProductRepository productRepository, RedisTemplate<String, ProductResponseDTO> redisTemplate) {
        this.productRepository = productRepository;
          this.redisTemplate=redisTemplate;
    }

    @Override
    public ProductResponseListDTO getAllProduct() {
            List< Product> products = productRepository.findAll();
        return ProductMapper.productToProductResponseDTO(products);
    }
    @Override
    public ProductResponseDTO getProductById(UUID id) throws ProductNotFoundException {

      ProductResponseDTO productResponseDTO= (ProductResponseDTO) redisTemplate.opsForHash().get("product",id);
      if (productResponseDTO!=null) {
          return productResponseDTO;
      }
      else {
          Optional<Product> product = productRepository.findById(id);

          if (product.isEmpty()) {
          throw new ProductNotFoundException("product not found at given id");
          }
          Product foundProduct = product.get();

          ProductResponseDTO productResponseDTOfound = ProductMapper.productToResponceDTO(foundProduct);
          redisTemplate.opsForHash().put("product",id,productResponseDTOfound);
          return productResponseDTO;
      }
    }

    @Override
    public ProductResponseDTO getProductByTitle(String title) throws InvalidTitleException, ProductNotFoundException {
        if(title==null||title.isEmpty() ) {
        throw new InvalidTitleException("title is empty or null");
        }
        Product product= productRepository.findByTitle(title);
        if (product == null){
            throw new ProductNotFoundException("Do not have product with given title");
        }

        return ProductMapper.productToResponceDTO(product);
    }

    @Override
    public ProductResponseDTO updateProduct(UUID id, ProductRequestDTO product) {

        Product product1=  ProductMapper.RequestDTOToproduct(product);
          return   ProductMapper.productToResponseDTO(productRepository.updateProduct(id,product1));

    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO product) {
        return null;
    }

    @Override
    public  boolean deleteProduct(UUID id) {
        productRepository.deleteById(id);
     return  true;
    }



}
