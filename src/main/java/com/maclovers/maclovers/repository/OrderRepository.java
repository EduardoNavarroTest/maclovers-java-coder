package com.maclovers.maclovers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maclovers.maclovers.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
