package org.example.hex.domain.order;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.hex.domain.order.shared.OrderState;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
class Order {
    private int orderId;
    private String dishName;
    private OrderState orderState;

    
}
