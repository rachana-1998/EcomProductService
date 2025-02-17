package com.rachana.EcomProductService.module;

import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Price extends BaseModel{
    private String currency;
    private double amt;
    private double discount;
}
