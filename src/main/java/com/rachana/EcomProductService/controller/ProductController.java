package com.rachana.EcomProductService.controller;

import com.rachana.EcomProductService.dto.ProductRequestDTO;
import com.rachana.EcomProductService.dto.ProductResponseDTO;
import com.rachana.EcomProductService.dto.ProductResponseListDTO;
import com.rachana.EcomProductService.productException.ProductException;
import com.rachana.EcomProductService.service.FakeProductServiceImpl;
import com.rachana.EcomProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class ProductController {



    private final ProductService productService;

    public ProductController(@Qualifier("fakeproductservice") ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/products/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById (@PathVariable("id") int id) throws ProductException {
        ProductResponseDTO productResponseDTO= productService.getProductById(id);
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

//    @DeleteMapping("/products/{id}")
//    public ResponseEntity  deleteProduct(@PathVariable("id")  int  id){
//          boolean idDeleted = productService.deleteProduct(id);
//         return  ResponseEntity.ok( idDeleted);
//    }
}
