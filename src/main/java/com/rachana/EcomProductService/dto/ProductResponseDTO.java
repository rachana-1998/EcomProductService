package com.rachana.EcomProductService.dto;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDTO {
    private UUID id;
    private String title;
    private double price;
    private String description;
    private  String image;
    private String category;


}
