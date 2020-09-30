package org.example.hex.domain.order.port.primary;

import org.example.hex.domain.order.port.shared.OrderState;

public interface FoodOrderService {

    int createOrder(String dishName, String address);

    OrderState getOrderState(int orderId);

}
