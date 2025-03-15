package com.rachana.EcomProductService.client;

import com.rachana.EcomProductService.dto.ValiadateDTO;
import com.rachana.EcomProductService.dto.fakeStore.FakeProductResponseDTO;
import com.rachana.EcomProductService.dto.fakeStore.FakeProductsRequestDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;


@Component
public class UserServiceClient {
    private final RestTemplateBuilder restTemplateBuilder;


    @Value("${userservice.api.path.validate}")
    private String userservicevalidatepath;

    private String userserviceAPIURL;

    public UserServiceClient(RestTemplateBuilder restTemplateBuilder,  @Value("${userservice.api.url}") String userserviceAPIURL) {
        this.restTemplateBuilder = restTemplateBuilder;

        this.userserviceAPIURL = userserviceAPIURL;
    }

    public String validateToken(ValiadateDTO validateToken){
        String url=userserviceAPIURL+userservicevalidatepath;
        RestTemplate restTemplate=restTemplateBuilder.build();
         ResponseEntity<String> productResponse=restTemplate.postForEntity(url, validateToken,String.class);
         return productResponse.getBody();
    }

    public FakeProductResponseDTO createProduct(FakeProductsRequestDTO fakeProductsRequestDTO){
        String url="https://fakestoreapi.com/products";
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeProductResponseDTO> fakeProductResponseDTO= restTemplate.postForEntity(url,fakeProductsRequestDTO,FakeProductResponseDTO.class);
        return  fakeProductResponseDTO.getBody();
    }


    public FakeProductResponseDTO getProductById(UUID Id){
        String url="https://fakestoreapi.com/products/"+Id;
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeProductResponseDTO> fakeProductResponseDTOResponseEntity = restTemplate.getForEntity(url,FakeProductResponseDTO.class);
        return fakeProductResponseDTOResponseEntity.getBody();
    }

    public List<FakeProductResponseDTO> getAllProduct(){
        String url="https://fakestoreapi.com/products";
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeProductResponseDTO[]> fakeProducts=  restTemplate.getForEntity(url,FakeProductResponseDTO[].class);
        return List.of(fakeProducts.getBody());
    }
}
