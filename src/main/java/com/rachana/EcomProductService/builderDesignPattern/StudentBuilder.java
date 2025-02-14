package com.rachana.EcomProductService.builderDesignPattern;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentBuilder {
    private String name;
    private String email;
    private String cources;
    private int age;
    private int fee;

    // Method to build a Student object
    public Student build() {
        return new Student(this);
    }
}

