package com.rachana.EcomProductService.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


@Setter
@Getter


public class ProductResponseListDTO {
  private   List<ProductResponseDTO> products;

  public ProductResponseListDTO( )  {
    this.products = new ArrayList<>();
  }

}
