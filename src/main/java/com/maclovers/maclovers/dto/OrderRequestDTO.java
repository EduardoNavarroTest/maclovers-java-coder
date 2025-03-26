package com.maclovers.maclovers.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.Map;

@Getter
@Setter
public class OrderRequestDTO {
    private Long customerId;
    private Map<Long, Long> productQuantities; 
}
