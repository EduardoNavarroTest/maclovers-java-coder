package com.maclovers.maclovers.controller;

import com.maclovers.maclovers.entity.Product;
import com.maclovers.maclovers.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Tag(name = "Products", description = "Operaciones para gestionar productos")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    @Operation(summary = "Obtener todos los productos", description = "Recupera una lista de todos los productos registrados.")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    @Operation(summary = "Crear un producto", description = "Agrega un nuevo producto a la base de datos.")
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }
}
