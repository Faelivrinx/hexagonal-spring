package org.example.hex.domain.order;

import lombok.Getter;
import org.example.hex.domain.order.port.primary.FoodOrderCommandService;
import org.example.hex.domain.order.port.primary.FoodOrderQueryService;
import org.example.hex.domain.order.port.secondary.Logistics;
import org.example.hex.domain.order.port.secondary.OrderStore;

@Getter
public class OrderFacade {

    private final FoodOrderCommandService foodOrderCommandService;
    private final FoodOrderQueryService foodOrderQueryServiceFacade;

    public OrderFacade(OrderStore orderStore, Logistics logistics) {
        this.foodOrderCommandService = new FoodOrderCommandServiceImpl(orderStore, logistics);
        foodOrderQueryServiceFacade = new FoodOrderQueryServiceFacadeImpl(orderStore);
    }
}
