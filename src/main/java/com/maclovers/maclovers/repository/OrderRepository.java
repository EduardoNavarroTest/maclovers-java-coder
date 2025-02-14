package com.maclovers.maclovers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.maclovers.maclovers.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
