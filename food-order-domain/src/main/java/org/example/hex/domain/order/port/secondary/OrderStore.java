package org.example.hex.domain.order.port.secondary;

import org.example.hex.domain.order.port.shared.OrderDto;
import org.example.hex.domain.order.port.shared.OrderState;

import java.util.Collection;

public interface OrderStore {

    void save(OrderDto order);

    OrderDto load(int orderId);

    Collection<OrderDto> findByState(OrderState orderState);

}
