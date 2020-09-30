package org.example.hex.domain.order;

import lombok.RequiredArgsConstructor;
import org.example.hex.domain.order.port.primary.FoodOrderService;
import org.example.hex.domain.order.port.secondary.OrderStore;
import org.example.hex.domain.order.port.shared.OrderDto;
import org.example.hex.domain.order.port.shared.OrderState;

@RequiredArgsConstructor
class FoodOrderServiceImpl implements FoodOrderService {

    private final OrderStore orderStore;

    @Override
    public int createOrder(String dishName, String address) {
        Order order = Order.OrderFactor.getInstance().createOrder(dishName, address);
        orderStore.save(Order.OrderFactor.getInstance().toOrderDto(order));
        return order.getOrderId();
    }

    @Override
    public OrderState getOrderState(int orderId) {
        OrderDto orderDto = orderStore.load(orderId);
        Order order = Order.OrderFactor.getInstance().from(orderDto);
        return order.getOrderState();

    }
}
