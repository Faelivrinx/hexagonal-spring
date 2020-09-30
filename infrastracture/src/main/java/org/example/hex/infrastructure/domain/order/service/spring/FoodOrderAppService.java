package org.example.hex.infrastructure.domain.order.service.spring;

import lombok.experimental.Delegate;
import org.example.hex.domain.order.OrderFacade;
import org.example.hex.domain.order.port.primary.FoodOrderService;
import org.springframework.stereotype.Service;

@Service
public class FoodOrderAppService implements FoodOrderService {

    @Delegate
    private final FoodOrderService delegate;

    public FoodOrderAppService(OrderFacade orderFacade) {
        this.delegate = orderFacade.getFoodOrderService();
    }
}
