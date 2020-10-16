package org.example.hex.infrastructure.domain.order.service.spring;

import lombok.experimental.Delegate;
import org.example.hex.domain.order.OrderFacade;
import org.example.hex.domain.order.port.primary.FoodOrderCommandService;
import org.springframework.stereotype.Service;

@Service
public class FoodOrderAppCommandService implements FoodOrderCommandService {

    @Delegate
    private final FoodOrderCommandService delegate;

    public FoodOrderAppCommandService(OrderFacade orderFacade) {
        this.delegate = orderFacade.getFoodOrderCommandService();
    }
}
