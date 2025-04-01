package com.maclovers.maclovers.controller;

import com.maclovers.maclovers.entity.Order;
import com.maclovers.maclovers.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
@Tag(name = "Orders", description = "Operaciones para gestionar órdenes")
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    @Operation(summary = "Obtener todas las órdenes", description = "Recupera una lista de todas las órdenes registradas.")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping
    @Operation(summary = "Crear una orden", description = "Agrega una nueva orden a la base de datos.")
    public Order createOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }
}
