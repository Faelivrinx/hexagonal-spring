package org.example.hex.domain.delivery.port.shared;

import lombok.Data;

@Data
public class OrderDetailsDto {
    private int foodOrderId;
    private String address;
}
