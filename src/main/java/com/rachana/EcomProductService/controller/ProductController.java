package com.rachana.EcomProductService.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rachana.EcomProductService.client.UserServiceClient;
import com.rachana.EcomProductService.dto.JwtPayloadDTO;
import com.rachana.EcomProductService.dto.SessionStatus;
import com.rachana.EcomProductService.dto.ValiadateDTO;
import com.rachana.EcomProductService.dto.request.ProductRequestDTO;
import com.rachana.EcomProductService.dto.response.ProductResponseDTO;
import com.rachana.EcomProductService.dto.response.ProductResponseListDTO;
import com.rachana.EcomProductService.productException.InvalidTitleException;
import com.rachana.EcomProductService.productException.InvalidTokenException;
import com.rachana.EcomProductService.productException.ProductNotFoundException;
import com.rachana.EcomProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.UUID;


@RestController
public class ProductController {



    private final ProductService productService;
    private final UserServiceClient userServiceClient;

    public ProductController(ProductService productService, UserServiceClient userServiceClient) {
        this.productService = productService;
        this.userServiceClient = userServiceClient;
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById (@PathVariable("id") UUID id,@RequestHeader("token") String token) throws ProductNotFoundException {
        ProductResponseDTO productResponseDTO= productService.getProductById(id);
        return ResponseEntity.ok(productResponseDTO);

    }
    @GetMapping("/products/title/{title}")
    public ResponseEntity<ProductResponseDTO> getProductByTitle(@PathVariable("title") String title,@RequestHeader("token") String token) throws ProductNotFoundException, InvalidTitleException {
        ProductResponseDTO productResponseDTO= productService.getProductByTitle(title);
        return ResponseEntity.ok(productResponseDTO);

    }

   @GetMapping("/products")
  public ResponseEntity<ProductResponseListDTO> getProducts(@RequestHeader("token") String token){
       ProductResponseListDTO productResponseDTOs=productService.getAllProduct();
       return  ResponseEntity.ok(productResponseDTOs);
    }

    @PostMapping("/products")
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductRequestDTO productRequestDTO,@RequestHeader("token") String token) throws Exception {


         validateUser(token);
        ProductResponseDTO productResponseDTO= productService.createProduct(productRequestDTO);
        return ResponseEntity.ok(productResponseDTO);
    }

    @PutMapping("/{id")
    public  ResponseEntity<ProductResponseDTO>   updateProduct(@PathVariable("id") UUID id,@RequestBody ProductRequestDTO product,@RequestHeader("token") String token){
       ProductResponseDTO responseDTO =productService.updateProduct(id,product);
        return ResponseEntity.ok(responseDTO);
    }


    @DeleteMapping("/products/{id}")
    public ResponseEntity<Boolean>  deleteProduct(@PathVariable("id")  UUID  id,@RequestHeader("token") String token) throws ProductNotFoundException {
          boolean isDeleted = productService.deleteProduct( id);
         return  ResponseEntity.ok( isDeleted);
    }
    private void validateUser(String token) throws Exception {
        String [] chunks=token.split("\\.");
        Base64.Decoder decoder=Base64.getUrlDecoder();
        String header=new String(decoder.decode(chunks[0]));
        String payloads=new String(decoder.decode(chunks[1]));
        ObjectMapper mapper=new ObjectMapper();
        JwtPayloadDTO jwtPayloadDTO=mapper.convertValue(payloads, JwtPayloadDTO.class);
        int userId= jwtPayloadDTO.getUserId();
        ValiadateDTO valiadateDTO=new ValiadateDTO(userId,token);
        String result= userServiceClient.validateToken(valiadateDTO);
       // throw new Exception("payload"+payloads+"header"+header);
        if(!result.equals(SessionStatus.ACTIVE.name()))
            throw new InvalidTokenException( "token is not valid");
    }
}
