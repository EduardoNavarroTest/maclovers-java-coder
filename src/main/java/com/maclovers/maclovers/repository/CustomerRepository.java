package com.maclovers.maclovers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.maclovers.maclovers.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
