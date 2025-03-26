package com.maclovers.maclovers.service;


import com.maclovers.maclovers.dto.OrderRequestDTO;
import com.maclovers.maclovers.entity.*;
import com.maclovers.maclovers.repository.CustomerRepository;
import com.maclovers.maclovers.repository.OrderRepository;
import com.maclovers.maclovers.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import java.sql.Date;
import java.time.ZoneId;
import java.util.Calendar;


@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;


    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order createOrder(OrderRequestDTO orderRequest) {
        Customer customer = customerRepository.findById(orderRequest.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        List<Product> products = productRepository.findAllById(orderRequest.getProductQuantities().keySet());

        if (products.size() != orderRequest.getProductQuantities().size()) {
            throw new RuntimeException("Uno o más productos no existen");
        }

        for (Product product : products) {
            long quantity = orderRequest.getProductQuantities().get(product.getId());

            if (product.getStock() < quantity) {
                throw new RuntimeException("Stock insuficiente para el producto: " + product.getName());
            }

            product.setStock(product.getStock() - (int) quantity);
            productRepository.save(product);
        }

        Date sqlDate = new Date(Calendar.getInstance().getTimeInMillis()); 
        Order order = Order.builder()
            .customer(customer)
            .products(products)
            .totalPrice(calculateTotalPrice(products, orderRequest.getProductQuantities()))
            .orderDate(sqlDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()) // ✅ Ahora es LocalDateTime

            .build();

        return orderRepository.save(order);
    }

    private double calculateTotalPrice(List<Product> products, Map<Long, Long> quantities) {
        return products.stream()
                .mapToDouble(product -> product.getPrice() * quantities.getOrDefault(product.getId(), 0L))
                .sum();
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
