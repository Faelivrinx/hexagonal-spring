package org.example.hex;

import org.example.hex.domain.order.OrderFacade;
import org.example.hex.domain.order.incoming.FoodOrderService;
import org.example.hex.domain.order.outgoing.OrderStore;
import org.example.hex.domain.order.shared.OrderDto;
import org.example.hex.domain.order.shared.OrderState;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class DomainTest {

    @Test
    public void simpleDomainTest() {
        OrderStore oderStore = new OrderStore() {
            private final Map<Integer, OrderDto> memory = new HashMap<>();
            @Override
            public void save(OrderDto orderDto) {
                System.out.println("OrderStore::save: " + orderDto.getOrderId());
                memory.put(orderDto.getOrderId(), orderDto);
            }

            @Override
            public OrderDto load(int orderId) {
                System.out.println("OrderStore::load: " + orderId);
                return memory.get(orderId);
            }
        };

        OrderFacade orderFacade = new OrderFacade(oderStore);
        FoodOrderService foodOrderService = orderFacade.getFoodOrderService();
        int orderId = foodOrderService.createOrder("Burger");
        System.out.println("OrderId: " + orderId);
        OrderState orderState = foodOrderService.getOrderState(orderId);
        System.out.println("OrderState: " + orderState);
    }

}
