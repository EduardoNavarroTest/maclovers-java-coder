package com.maclovers.maclovers.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Order {

    @Id
    private Long id;

    @ManyToOne
    private Customer customer;

    @OneToMany
    private List<Product> products;

    private String orderStatus;
    private Double totalAmount;
}