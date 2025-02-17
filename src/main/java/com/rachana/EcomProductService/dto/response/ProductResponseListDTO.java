package com.rachana.EcomProductService.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseListDTO {
  private   List<ProductResponseDTO> products;

// // public ProductResponseListDTO( )  {
//    this.products = new ArrayList<>();
//  }

}
