package com.rachana.EcomProductService.cntroller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rachana.EcomProductService.dto.request.ProductRequestDTO;
import com.rachana.EcomProductService.dto.response.ProductResponseDTO;
import com.rachana.EcomProductService.dto.response.ProductResponseListDTO;
import com.rachana.EcomProductService.module.Category;
import com.rachana.EcomProductService.module.Price;
import com.rachana.EcomProductService.productException.ProductNotFoundException;
import com.rachana.EcomProductService.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
public class ProductControllerTest {

 @Autowired
    private MockMvc mockMvc;

 @MockitoBean("productservice")
    private ProductService productService;
 @MockitoBean
    private ProductNotFoundException productException;

 @Test
    public void getAllProductReturnWhenNoProductAvalable() throws Exception {

       ProductResponseListDTO emptyResopnseList=new ProductResponseListDTO();

       Mockito.when(productService.getAllProduct()).thenReturn(emptyResopnseList);
       mockMvc.perform(get("/products"))
             .andExpect(status().is(200))
             .andExpect(content().string("{\"products\":[]}"));
 }



 @Test
    public void getAllProduct() throws Exception {
     Category category=new Category();
     category.setCategoryName("electronics");
     Price price =new Price();
     price.setAmt(108080);
     ProductResponseListDTO productResponseListDTO=new ProductResponseListDTO();
     ProductResponseDTO prduct1=new ProductResponseDTO();
     prduct1.setId(UUID.fromString("1ef8aab7-b33a-45c2-8320-3872aa099743"));
     prduct1.setImage("http:/iphone");
     prduct1.setTitle("Iphone");
     prduct1.setDescription("best phone");
     prduct1.setCategory(category);
     prduct1.setPrice(price);

     ProductResponseDTO product2=new ProductResponseDTO();
     product2.setId(UUID.fromString("91ef2164-f534-4f82-b504-a58079db39a7"));
     product2.setImage("http:/iphone");
     product2.setTitle("Mackbook");
     product2.setDescription("best phone");
     product2.setCategory(category);
     product2.setPrice(price);

     productResponseListDTO.setProducts(List.of(prduct1,product2));

     Mockito.when(productService.getAllProduct()).thenReturn(productResponseListDTO );

     mockMvc.perform(get("/products"))
             .andExpect(status().is(200))
             .andExpect(content().string("{\"products\":[{\"id\":\"1ef8aab7-b33a-45c2-8320-3872aa099743\",\"title\":\"Iphone\",\"price\":108080.0,\"description\":\"best phone\",\"image\":\"http:/iphone\",\"category\":\"Electronics\"},{\"id\":\"91ef2164-f534-4f82-b504-a58079db39a7\",\"title\":\"Mackbook\",\"price\":108080.0,\"description\":\"best phone\",\"image\":\"http:/iphone\",\"category\":\"Electronics\"}]}"));
 }

 @Test
 public void createProduct() throws Exception {
     Category category=new Category();
     category.setCategoryName("electronics");

     Price price =new Price();
     price.setAmt(108080);

     ProductRequestDTO productRequestDTO = new ProductRequestDTO();
     productRequestDTO.setPrice(price);
     productRequestDTO.setCategory(category);
     productRequestDTO.setTitle("smartWatch");
     productRequestDTO.setDescription("bestappleproduct");
     productRequestDTO.setImage("/smartwatch");


     ProductResponseDTO productResponseDTO = new ProductResponseDTO();
     productResponseDTO.setPrice(price);
     productResponseDTO.setCategory(category);
     productResponseDTO.setTitle("smartWatch");
     productResponseDTO.setDescription("bestappleproduct");
     productResponseDTO.setImage("/smartwatch");
     productResponseDTO.setId(UUID.randomUUID());


     String requestJson = convertToJson(productRequestDTO);
     String responseString = convertToJson(productResponseDTO);

     Mockito.when(productService.createProduct(any())).thenReturn(productResponseDTO);

          mockMvc.perform(post("/products")
                  .contentType(MediaType.APPLICATION_JSON)
                  .content(requestJson))
                  .andExpect(status().is(200))
                   .andExpect(content().string(responseString));


 }
 private String convertToJson(Object object) throws JsonProcessingException {
  ObjectMapper mapper = new ObjectMapper();
  return mapper.writeValueAsString(object);
 }

 @Test
    public void deleteByIdTest() throws Exception {
     Mockito.when(productService.deleteProduct(UUID.fromString("91ef2164-f534-4f82-b504-a58079db39a7"))).thenReturn(true);

     mockMvc.perform(get("/products/91ef2164-f534-4f82-b504-a58079db39a7")).andExpect(status().is(200)).andExpect( content().string(""));
 }

 @Test
    public  void findProductByIdFailure() throws Exception {
     Mockito.when(productService.getProductById(UUID.randomUUID()))
             .thenThrow(new ProductNotFoundException());
     mockMvc.perform(get("/products/91ef2164-f534-4f82-b504-a58079db39a7"))
             .andExpect(status().is(200))
             .andExpect(content().string(""));
 }
 @Test
    public  void  findProByTitle() throws Exception {

     Category category=new Category();
     category.setCategoryName("electronics");

     Price price =new Price();
     price.setAmt(108080);

     ProductResponseDTO prduct1=new ProductResponseDTO();

     prduct1.setId(UUID.fromString("1ef8aab7-b33a-45c2-8320-3872aa099743"));
     prduct1.setImage("http:/iphone");
     prduct1.setTitle("Iphone");
     prduct1.setDescription("best phone");
     prduct1.setCategory(category);
     prduct1.setPrice(price);
     Mockito.when(productService.getProductByTitle("Iphone")).thenReturn(prduct1);
     mockMvc.perform(get("/products/title/Iphone"))
             .andExpect(status().is(200))
             .andExpect(content().string("{\"id\":\"1ef8aab7-b33a-45c2-8320-3872aa099743\",\"title\":\"Iphone\",\"price\":108080.0,\"description\":\"best phone\",\"image\":\"http:/iphone\",\"category\":\"Electronics\"}"));
 }


}
