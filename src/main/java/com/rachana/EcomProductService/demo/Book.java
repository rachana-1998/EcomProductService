package com.rachana.EcomProductService.demo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private  String name;
    @ManyToOne
    @JoinColumn(name = "auther")
    private Auther auther;

public Book(){

}
    public Book(String name, Auther auther) {
        this.name = name;
        this.auther = auther;
    }
}
