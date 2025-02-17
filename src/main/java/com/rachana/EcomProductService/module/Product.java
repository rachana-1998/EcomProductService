package com.rachana.EcomProductService.module;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Product extends BaseModel {
    private String title;
    private String description;
    private  String image;
    @ManyToOne
    private Category category;
    @OneToOne
    private Price price;
    @ManyToMany(mappedBy = "products")
    private List<ProductOrders> productOrders;
}
