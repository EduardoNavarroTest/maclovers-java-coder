package com.maclovers.maclovers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.maclovers.maclovers.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
