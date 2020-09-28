package org.example.hex.domain.order.shared;

import lombok.Data;

@Data
public class OrderDto {
    private int orderId;
    private String dishName;
    private OrderState orderState;
}
