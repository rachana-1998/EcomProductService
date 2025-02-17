package com.rachana.EcomProductService.dto.fakeStore;

import lombok.Getter;
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
