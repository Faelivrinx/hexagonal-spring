package org.example.hex.domain.order;

import lombok.RequiredArgsConstructor;
import org.example.hex.domain.order.incoming.FoodOrderService;
import org.example.hex.domain.order.outgoing.OrderStore;
import org.example.hex.domain.order.shared.OrderDto;
import org.example.hex.domain.order.shared.OrderState;

@RequiredArgsConstructor
class FoodOrderServiceImpl implements FoodOrderService {

    private final OrderStore orderStore;

    @Override
    public int createOrder(String dishName) {
        Order order = Order.OrderFactor.getInstance().createOrder(dishName);
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
