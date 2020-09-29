package org.example.hex.infrastructure.domain.order.adapter.secondary;

import lombok.extern.slf4j.Slf4j;
import org.example.hex.domain.order.outgoing.OrderStore;
import org.example.hex.domain.order.shared.OrderDto;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class InMemoryOrderStore implements OrderStore {

    private final Map<Integer, OrderDto> memory = new HashMap<>();

    @Override
    public void save(OrderDto orderDto) {
        log.info("save: orderId[{}]", orderDto.getOrderId());
        memory.put(orderDto.getOrderId(), orderDto);
    }

    @Override
    public OrderDto load(int orderId) {
        log.info("load: orderId [{}]", orderId);
        return memory.get(orderId);
    }
}
