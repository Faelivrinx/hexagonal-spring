package org.example.hex.domain.order.incoming;

import org.example.hex.domain.order.shared.OrderState;

public interface FoodOrderService {

    int createOrder(String dishName);

    OrderState getOrderState(int orderId);

}
