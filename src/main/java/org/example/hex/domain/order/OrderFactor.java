package org.example.hex.domain.order;

import lombok.Getter;
import org.example.hex.domain.order.shared.OrderState;

import java.util.concurrent.atomic.AtomicInteger;

class OrderFactor {

    private static final AtomicInteger SEQUENCE = new AtomicInteger();
    @Getter
    private static final OrderFactor instance = new OrderFactor();

    Order createOrder(String dishName){
        return new Order(SEQUENCE.incrementAndGet(), dishName, OrderState.NEW);
    }


}
