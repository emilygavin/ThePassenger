package com.example.demo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Data
@Document
public class Passenger {
    private String title;
    private String name;
    @Id
    private String ID;
    @Indexed(unique = true)
    private String phoneNumber;
    private Integer age;

    public Passenger(String title, String name, String phoneNumber, Integer age) {
        this.title = title;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }
}
