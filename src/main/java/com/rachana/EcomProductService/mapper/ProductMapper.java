package com.rachana.EcomProductService.mapper;

import com.rachana.EcomProductService.dto.fakeStore.FakeProductResponseDTO;
import com.rachana.EcomProductService.dto.fakeStore.FakeProductsRequestDTO;
import com.rachana.EcomProductService.dto.request.ProductRequestDTO;
import com.rachana.EcomProductService.dto.response.ProductResponseDTO;
import com.rachana.EcomProductService.dto.response.ProductResponseListDTO;
import com.rachana.EcomProductService.module.Product;

import java.util.List;

public class ProductMapper {

    public static FakeProductsRequestDTO productRequestTofakeproduct(ProductRequestDTO productRequestDTO){
        FakeProductsRequestDTO fakeProductsRequestDTO=new FakeProductsRequestDTO();
        fakeProductsRequestDTO.setTitle(productRequestDTO.getTitle());
        //  fakeProductsRequestDTO.setCategory(productRequestDTO.getCategory());
        fakeProductsRequestDTO.setImage(productRequestDTO.getImage());
        //fakeProductsRequestDTO.setPrice(productRequestDTO.getPrice());
        fakeProductsRequestDTO.setDescription(productRequestDTO.getDescription());
        return  fakeProductsRequestDTO;
    }


    public static ProductResponseDTO fakeProductResponseToProductResponse(FakeProductResponseDTO fakeProductResponseDTO){
        ProductResponseDTO productResponseDTO=new ProductResponseDTO();
        productResponseDTO.setId(fakeProductResponseDTO.getId());
       // productResponseDTO.setPrice(fakeProductResponseDTO.getPrice());
        productResponseDTO.setImage(fakeProductResponseDTO.getImage());
        productResponseDTO.setTitle(fakeProductResponseDTO.getTitle());
       // productResponseDTO.setCategory(fakeProductResponseDTO.getCategory());
        productResponseDTO.setDescription(fakeProductResponseDTO.getDescription());
        return productResponseDTO;
    }
    public  static ProductResponseListDTO productToProductResponseDTO(List<Product> products){
        ProductResponseListDTO productResponseListDTO=new ProductResponseListDTO();
        for(Product p:products){
            ProductResponseDTO   responseDTO=new ProductResponseDTO();
            responseDTO.setId(p.getUuid());
            responseDTO.setDescription(p.getDescription());
            responseDTO.getCategory().setCategoryName(p.getCategory().getCategoryName());
            responseDTO.setImage(p.getImage());
            responseDTO.getPrice().setAmt(p.getPrice().getAmt());
            responseDTO.setTitle(p.getTitle());
            productResponseListDTO.getProducts().add(responseDTO);

        }
        return  productResponseListDTO;
    }
    public  static  ProductResponseDTO productToResponceDTO(Product product){
        ProductResponseDTO productResponseDTO=new ProductResponseDTO();
        productResponseDTO.setTitle(product.getTitle());
        productResponseDTO.setDescription(product.getDescription());
        productResponseDTO.getCategory().setCategoryName(product.getCategory().getCategoryName());
        productResponseDTO.setImage(product.getImage());
        productResponseDTO.getPrice().setAmt(product.getPrice().getAmt());
        productResponseDTO.setId(product.getUuid());
        return  productResponseDTO;
    }
    public static ProductResponseDTO productToResponseDTO(Product product){

        ProductResponseDTO responseDTO=new ProductResponseDTO();
        responseDTO.setTitle(product.getTitle());
        responseDTO.getCategory().setCategoryName(product.getCategory().getCategoryName());

        responseDTO.setImage(product.getImage());
        responseDTO.getPrice().setAmt(product.getPrice().getAmt());
        responseDTO.setDescription(product.getDescription());
        return  responseDTO ;
    }
    public static Product  RequestDTOToproduct(ProductRequestDTO productResponseDTO){
        Product product= new Product();
        product.setTitle(productResponseDTO.getTitle());
        product.getCategory().setCategoryName(productResponseDTO.getCategory().getCategoryName());
        product.setImage(productResponseDTO.getImage());
        product.setPrice(productResponseDTO.getPrice());
        product.setDescription(productResponseDTO.getDescription());
        return  product ;
    }

}
