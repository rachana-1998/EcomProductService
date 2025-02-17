package com.rachana.EcomProductService.client;

import com.rachana.EcomProductService.dto.fakeStore.FakeProductResponseDTO;
import com.rachana.EcomProductService.dto.fakeStore.FakeProductsRequestDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;


@Component
public class FakeStoreProductClient {
    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreProductClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
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
