package com.maclovers.maclovers;

import com.maclovers.maclovers.entity.Customer;
import com.maclovers.maclovers.entity.Order;
import com.maclovers.maclovers.entity.Product;
import com.maclovers.maclovers.repository.CustomerRepository;
import com.maclovers.maclovers.repository.OrderRepository;
import com.maclovers.maclovers.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        if (productRepository.count() == 0) {

            // Crear productos
            Product macbook = Product.builder()
                    .name("MacBook Air M2")
                    .price(1500.0)
                    .build();

            Product imac = Product.builder()
                    .name("iMac 24 pulgadas")
                    .price(1800.0)
                    .build();

            Product macStudio = Product.builder()
                    .name("Mac Studio")
                    .price(3500.0)
                    .build();

            productRepository.saveAll(List.of(macbook, imac, macStudio));

            // Crear cliente
            Customer customer = Customer.builder()
                    .name("Eduardo Navarro")
                    .email("eduardo.navarro@maclovers.com")
                    .build();

            customerRepository.save(customer);

            // Crear orden para el cliente y asociar productos
            List<Product> productsForOrder = List.of(macbook, macStudio);

            Order order = Order.builder()
                    .orderDate(LocalDate.now())
                    .customer(customer)
                    .description("Subanme el sueldo por favor")
                    .products(productsForOrder)
                    .build();

            orderRepository.save(order);

            log.info("Datos iniciales insertados correctamente.");

        } else {
            log.info("Los datos iniciales ya existen. No se insertaron duplicados.");
        }
    }
}
