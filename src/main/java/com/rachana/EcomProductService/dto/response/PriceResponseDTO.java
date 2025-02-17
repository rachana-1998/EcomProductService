package com.rachana.EcomProductService.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class PriceResponseDTO {
    private UUID id;
    private String currency;
    private double amt;
    private double discount;

}
