package com.rachana.EcomProductService.dto.response;

import com.rachana.EcomProductService.module.Category;
import com.rachana.EcomProductService.module.Price;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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

    private String description;
    private  String image;
    @ManyToOne
    private Category category;
    @OneToOne
    private Price price;


}
