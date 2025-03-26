package com.maclovers.maclovers.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor // 🔹 Genera un constructor con todos los campos
@NoArgsConstructor
public class OrderResponseDTO {

    private Long id;
    private String customerName; // Suponiendo que necesitas el nombre del cliente
    private List<String> productNames;
    private Integer totalQuantity;
    private Double totalPrice;
    private LocalDateTime orderDate;
}
