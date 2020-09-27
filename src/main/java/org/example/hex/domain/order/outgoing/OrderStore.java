package org.example.hex.domain.order.outgoing;

import org.example.hex.domain.order.shared.OrderDto;

public interface OrderStore {

    void save(OrderDto order);

    OrderDto load(int orderId);

}
