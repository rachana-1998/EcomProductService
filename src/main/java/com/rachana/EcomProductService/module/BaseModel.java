package com.rachana.EcomProductService.module;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Setter
@Getter
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(generator="uuidGenerator")
    @GenericGenerator(name="uuidGenerator", strategy="uuid2")
    @Column(name = "id",  nullable = false,updatable = false)
    private UUID uuid;
}
