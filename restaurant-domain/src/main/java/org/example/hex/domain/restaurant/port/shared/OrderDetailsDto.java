package org.example.hex.domain.restaurant.port.shared;

import lombok.Data;

@Data
public class OrderDetailsDto {
    private int foodOrderId;
    private String dishName;
}
