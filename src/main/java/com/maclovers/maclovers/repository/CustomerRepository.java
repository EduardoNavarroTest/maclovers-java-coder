package com.maclovers.maclovers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maclovers.maclovers.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
