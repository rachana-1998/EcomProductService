package com.rachana.EcomProductService.dto.request;

import com.rachana.EcomProductService.module.Category;
import com.rachana.EcomProductService.module.Price;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDTO {
    private String title;
    private String description;
    private  String image;
    @ManyToOne
    private Category category;
    @OneToOne
    private Price price;
}
