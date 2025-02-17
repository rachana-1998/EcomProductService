package com.rachana.EcomProductService.controller;

import com.rachana.EcomProductService.dto.request.ProductRequestDTO;
import com.rachana.EcomProductService.dto.response.ProductResponseDTO;
import com.rachana.EcomProductService.dto.response.ProductResponseListDTO;
import com.rachana.EcomProductService.productException.InvalidTitleException;
import com.rachana.EcomProductService.productException.ProductNotFoundException;
import com.rachana.EcomProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
public class ProductController {



    private final ProductService productService;

    public ProductController(@Qualifier("productservice") ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/products/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById (@PathVariable("id") UUID id) throws ProductNotFoundException {
        ProductResponseDTO productResponseDTO= productService.getProductById(id);
        return ResponseEntity.ok(productResponseDTO);

    }
    @GetMapping("/products/title/{title}")
    public ResponseEntity<ProductResponseDTO> getProductByTitle(@PathVariable("title") String title) throws ProductNotFoundException, InvalidTitleException {
        ProductResponseDTO productResponseDTO= productService.getProductByTitle(title);
        return ResponseEntity.ok(productResponseDTO);

    }

   @GetMapping("/products")
  public ResponseEntity<ProductResponseListDTO> getProducts(){
       ProductResponseListDTO productResponseDTOs=productService.getAllProduct();
       return  ResponseEntity.ok(productResponseDTOs);
    }

    @PostMapping("/products")
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductRequestDTO productRequestDTO){
        ProductResponseDTO productResponseDTO= productService.createProduct(productRequestDTO);
        return ResponseEntity.ok(productResponseDTO);
    }

    @PutMapping("/{id")
    public  ResponseEntity<ProductResponseDTO>   updateProduct(@PathVariable("id") UUID id,@RequestBody ProductRequestDTO product){
       ProductResponseDTO responseDTO =productService.updateProduct(id,product);
        return ResponseEntity.ok(responseDTO);
    }


    @DeleteMapping("/products/{id}")
    public ResponseEntity  deleteProduct(@PathVariable("id")  UUID  id){
          boolean idDeleted = productService.deleteProduct( id);
         return  ResponseEntity.ok( idDeleted);
    }
}
