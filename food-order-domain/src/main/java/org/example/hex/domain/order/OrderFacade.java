package org.example.hex.domain.order;

import lombok.Getter;
import org.example.hex.domain.order.port.primary.FoodOrderService;
import org.example.hex.domain.order.port.secondary.OrderStore;

@Getter
public class OrderFacade {

    private final FoodOrderService foodOrderService;

    public OrderFacade(OrderStore orderStore) {
        this.foodOrderService = new FoodOrderServiceImpl(orderStore);
    }
}
