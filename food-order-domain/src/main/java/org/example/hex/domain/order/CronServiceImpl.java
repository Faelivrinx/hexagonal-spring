package org.example.hex.domain.order;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.hex.domain.order.port.primary.CronService;
import org.example.hex.domain.order.port.secondary.Logistics;
import org.example.hex.domain.order.port.secondary.OrderStore;
import org.example.hex.domain.order.port.shared.OrderDto;
import org.example.hex.domain.order.port.shared.OrderState;

import java.util.Collection;

@Slf4j
@RequiredArgsConstructor
public class CronServiceImpl implements CronService {
    private final OrderStore orderStore;
    private final Logistics logistics;

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
}

