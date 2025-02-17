package com.rachana.EcomProductService.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter

public class FakeProductResponseDTO {
    private UUID id;
    private String title;
    private double price;
    private  String category;
    private String description;
    private  String image;
}
