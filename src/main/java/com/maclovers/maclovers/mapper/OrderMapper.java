package com.maclovers.maclovers.mapper;

import java.util.stream.Collectors;

import com.maclovers.maclovers.dto.OrderResponseDTO;
import com.maclovers.maclovers.entity.Order;
import com.maclovers.maclovers.entity.Product;

public class OrderMapper {
    public static OrderResponseDTO toResponseDTO(Order order) {
        return new OrderResponseDTO(
            order.getId(),
            order.getCustomer().getName(),
            order.getProducts().stream().map(Product::getName).collect(Collectors.toList()),
            order.getTotalQuantity(),
            order.getTotalPrice(),
            order.getOrderDate() // ✅ Usa getOrderDate() en lugar de getDate()
        );
    }
}
