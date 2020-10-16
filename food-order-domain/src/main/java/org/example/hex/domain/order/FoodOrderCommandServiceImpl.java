package org.example.hex.domain.order;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.hex.domain.order.port.primary.FoodOrderCommandService;
import org.example.hex.domain.order.port.secondary.Logistics;
import org.example.hex.domain.order.port.secondary.OrderStore;
import org.example.hex.domain.order.port.shared.OrderDto;
import org.example.hex.domain.order.port.shared.OrderState;

import java.util.Collection;

@RequiredArgsConstructor
@Slf4j
class FoodOrderCommandServiceImpl implements FoodOrderCommandService {

    private final OrderStore orderStore;
    private final Logistics logistics;

    @Override
    public int createOrder(String dishName, String address) {
        Order order = Order.OrderFactor.getInstance().createOrder(dishName, address);
        orderStore.save(Order.OrderFactor.getInstance().toOrderDto(order));
        return order.getOrderId();
    }

    @Override
    public void markAsReadyToDelivery(int orderId) {
        changeOrderState(orderId, OrderState.READY_TO_DELIVERY);
    }

    @Override
    public void markAsDelivered(int orderId) {
        changeOrderState(orderId, OrderState.DELIVERED);
    }

    @Override
    public void makeOrders() {
        Collection<OrderDto> newOrders = orderStore.findByState(OrderState.NEW);
        Collection<OrderDto> readyToDeliveryOrders = orderStore.findByState(OrderState.READY_TO_DELIVERY);

        newOrders.forEach(order -> {
            log.info("Preparing order {}", order.getOrderId());
            logistics.prepareOrder(order.getOrderId());
        });

        readyToDeliveryOrders.forEach(order -> {
            log.info("Delivering order {}", order.getOrderId());
            logistics.deliver(order.getOrderId());
        });
    }

    private void changeOrderState(int orderId, OrderState readyToDelivery) {
        OrderDto orderDto = orderStore.load(orderId);
        Order order = Order.OrderFactor.getInstance().from(orderDto);
        order.changeState(readyToDelivery);
        orderStore.save(Order.OrderFactor.getInstance().toOrderDto(order));
    }
}
