package com.websystique.springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
public class Company {
    private String name;
    private String address;

    public Company() {
        this.name = "Unknown";
        this.address = "Unknown";
    }
}
