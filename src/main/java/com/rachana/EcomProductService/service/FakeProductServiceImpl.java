package com.rachana.EcomProductService.service;

import com.rachana.EcomProductService.client.FakeStoreProductClient;
import com.rachana.EcomProductService.dto.fakeStore.FakeProductResponseDTO;
import com.rachana.EcomProductService.dto.fakeStore.FakeProductsRequestDTO;
import com.rachana.EcomProductService.dto.request.ProductRequestDTO;
import com.rachana.EcomProductService.dto.response.ProductResponseDTO;
import com.rachana.EcomProductService.dto.response.ProductResponseListDTO;
import com.rachana.EcomProductService.productException.ProductNotFoundException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.rachana.EcomProductService.mapper.ProductMapper.fakeProductResponseToProductResponse;
import static com.rachana.EcomProductService.mapper.ProductMapper.productRequestTofakeproduct;
import static com.rachana.EcomProductService.util.ProductUtil.isNull;

import java.util.List;
import java.util.UUID;

@Service("fakeproductservice")
public class FakeProductServiceImpl implements ProductService{

   private RestTemplateBuilder restTemplateBuilder;
   private FakeStoreProductClient fakeStoreProductClient;

    public FakeProductServiceImpl(RestTemplateBuilder restTemplateBuilder, FakeStoreProductClient fakeStoreProductClient) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreProductClient = fakeStoreProductClient;
    }

    @Override
    public ProductResponseListDTO getAllProduct() {
        List<FakeProductResponseDTO> fakeProductResponseDTOS=fakeStoreProductClient.getAllProduct();
         ProductResponseListDTO productResponseListDTO=new ProductResponseListDTO();
        for(FakeProductResponseDTO product:fakeProductResponseDTOS){
             productResponseListDTO.getProducts().add(fakeProductResponseToProductResponse(product));
        }
        return productResponseListDTO;
    }

    @Override
    public ProductResponseDTO getProductById(UUID id) throws ProductNotFoundException {
        FakeProductResponseDTO fakeProductResponseDTO=fakeStoreProductClient.getProductById(id);
        if(!(isNull(fakeProductResponseDTO))){
        ProductResponseDTO productResponseDTO=fakeProductResponseToProductResponse(fakeProductResponseDTO);
            return  productResponseDTO;
        }
        throw new ProductNotFoundException("product not found with id :"+id);

    }

    @Override
    public ProductResponseDTO updateProduct(UUID id, ProductRequestDTO product) {

        return null;
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO product) {
       FakeProductsRequestDTO fakeProductsRequestDTO= productRequestTofakeproduct(product);
       FakeProductResponseDTO fakeProductResponseDTOResponseEntity = fakeStoreProductClient.createProduct(fakeProductsRequestDTO);
             return  fakeProductResponseToProductResponse(fakeProductResponseDTOResponseEntity);
    }

    @Override
    public boolean deleteProduct(UUID id) {
        String url="https://fakestoreapi.com/products/"+id;
        RestTemplate restTemplate=restTemplateBuilder.build();
        restTemplate.delete(url) ;
         return true;
    }

    @Override
    public ProductResponseDTO getProductByTitle(String title) {
        return null;
    }
}
