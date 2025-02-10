package com.rachana.EcomProductService.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
public class ProductResponseListDTO {
  private   List<ProductResponseDTO> prducts;
}
