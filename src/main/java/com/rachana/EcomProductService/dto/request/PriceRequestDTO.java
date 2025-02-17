package com.rachana.EcomProductService.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class PriceRequestDTO {
    private UUID id;
    private String currency;
    private double amt;
    private double discount;

}

