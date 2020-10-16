package org.example.hex.domain.order;

import lombok.RequiredArgsConstructor;
import org.example.hex.domain.order.port.primary.FoodOrderQueryService;
import org.example.hex.domain.order.port.secondary.OrderStore;
import org.example.hex.domain.order.port.shared.OrderDto;

@RequiredArgsConstructor
class FoodOrderQueryServiceFacadeImpl implements FoodOrderQueryService {

    private final OrderStore orderStore;

    @Override
    public OrderDto getOrderDetails(int orderId) {
        return orderStore.load(orderId);
    }
}
