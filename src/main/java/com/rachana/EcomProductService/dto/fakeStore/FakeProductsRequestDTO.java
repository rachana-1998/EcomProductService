package com.rachana.EcomProductService.dto.fakeStore;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class FakeProductsRequestDTO {

    private String title;
    private double price;
    private  String category;
    private String description;
    private  String image;
}
