package org.example.hex.domain.order.port.shared;

import lombok.Data;

@Data
public class OrderDto {
    private int orderId;
    private String dishName;
    private String address;
    private OrderState orderState;
}
