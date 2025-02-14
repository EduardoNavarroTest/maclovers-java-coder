package com.maclovers.maclovers.entity;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String description;
    private Double price;
    private String category;
    private Integer stockQuantity;
}
