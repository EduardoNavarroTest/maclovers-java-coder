package com.maclovers.maclovers.controller;

import com.maclovers.maclovers.entity.Customer;
import com.maclovers.maclovers.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
@Tag(name = "Customers", description = "Operaciones para gestionar clientes")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    @Operation(summary = "Obtener todos los clientes", description = "Recupera una lista de todos los clientes registrados.")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping
    @Operation(summary = "Crear un cliente", description = "Agrega un nuevo cliente a la base de datos.")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }
}
