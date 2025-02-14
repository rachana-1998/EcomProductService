package com.rachana.EcomProductService.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDTO {
    private int id;
    private String title;
    private double price;
    private  String category;
    private String description;
    private  String image;


}
