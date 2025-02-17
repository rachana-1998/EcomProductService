package com.rachana.EcomProductService.demo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@Entity
@ToString
public class Auther {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @OneToMany(mappedBy = "auther" ,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Book> book;

    public Auther(){

    }

    public Auther(String name, List<Book> book) {
        this.name = name;
        this.book = book;
    }
}
