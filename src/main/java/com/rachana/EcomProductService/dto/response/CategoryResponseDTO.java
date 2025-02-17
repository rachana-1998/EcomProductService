package com.rachana.EcomProductService.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
public class CategoryResponseDTO {

    private UUID id;
    private String name;
}
