package org.example.hex.infrastructure.domain.order.adapter.secondary;

import lombok.extern.slf4j.Slf4j;
import org.example.hex.domain.order.port.secondary.OrderStore;
import org.example.hex.domain.order.port.shared.OrderDto;
import org.example.hex.domain.order.port.shared.OrderState;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

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

    @Override
    public Collection<OrderDto> findByState(OrderState orderState) {
        return memory.values()
                .stream()
                .filter(orderDto -> orderDto.getOrderState() == orderState)
                .collect(Collectors.toList());
    }
}
