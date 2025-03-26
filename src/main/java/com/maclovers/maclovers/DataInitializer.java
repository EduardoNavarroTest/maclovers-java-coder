package com.maclovers.maclovers;

import com.maclovers.maclovers.entity.Customer;
import com.maclovers.maclovers.entity.Order;
import com.maclovers.maclovers.entity.Product;
import com.maclovers.maclovers.repository.CustomerRepository;
import com.maclovers.maclovers.repository.OrderRepository;
import com.maclovers.maclovers.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    @PostConstruct
    public void initData() {
        // Crear clientes
        Customer customer1 = new Customer( "Eduardo Navarro", "eduardo@example.com");
        Customer customer2 = new Customer( "María López", "maria@example.com");
        customerRepository.saveAll(Arrays.asList(customer1, customer2));

        // Crear productos
        Product product1 = new Product(null, "MacBook Pro", 2500.0, 10);
        Product product2 = new Product(null, "iPhone 15", 1200.0, 15);
        productRepository.saveAll(Arrays.asList(product1, product2));

        // Crear órdenes
        Order order1 = Order.builder()
                .customer(customer1)
                .products(List.of(product1, product2))
                .totalQuantity(2)
                .totalPrice(product1.getPrice() + product2.getPrice())
                .orderDate(LocalDateTime.now()) // ✅ Aseguramos que sea LocalDateTime
                .build();

        Order order2 = Order.builder()
                .customer(customer2)
                .products(List.of(product2))
                .totalQuantity(1)
                .totalPrice(product2.getPrice())
                .orderDate(LocalDateTime.now().minusDays(2)) // ✅ Fecha anterior como ejemplo
                .build();

        orderRepository.saveAll(Arrays.asList(order1, order2));

        System.out.println("📦 Datos de prueba insertados correctamente.");
    }
}
