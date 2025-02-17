package com.rachana.EcomProductService.module;

import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Category extends BaseModel {

    private  String categoryName;
}
