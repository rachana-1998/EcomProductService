package com.rachana.EcomProductService.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter

public class CategoryRequestDTO {
    private UUID id;
    private String name;
}
