package org.example.hex.domain.order;

import lombok.RequiredArgsConstructor;
import lombok.Getter;
import org.example.hex.domain.order.incoming.FoodOrderService;

@RequiredArgsConstructor
@Getter
public class OrderFacade {

    private final FoodOrderService foodOrderService;

}
