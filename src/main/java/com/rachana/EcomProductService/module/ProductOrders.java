package com.rachana.EcomProductService.module;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class ProductOrders extends BaseModel{
    @ManyToMany
    private List<Product> products;
}
