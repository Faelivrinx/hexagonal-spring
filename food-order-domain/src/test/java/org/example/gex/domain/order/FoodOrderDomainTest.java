package org.example.gex.domain.order;

import org.example.hex.domain.order.OrderFacade;
import org.example.hex.domain.order.port.primary.FoodOrderCommandService;
import org.example.hex.domain.order.port.primary.FoodOrderQueryService;
import org.example.hex.domain.order.port.secondary.Logistics;
import org.example.hex.domain.order.port.secondary.OrderStore;
import org.example.hex.domain.order.port.shared.OrderDto;
import org.example.hex.domain.order.port.shared.OrderState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FoodOrderDomainTest {

    @Test
    void test(){
        OrderStore orderStore = new OrderStore() {

            private final Map<Integer, OrderDto> memory = new HashMap<>();

            @Override
            public void save(OrderDto orderDto) {
                memory.put(orderDto.getOrderId(), orderDto);
            }

            @Override
            public OrderDto load(int orderId) {
                return memory.get(orderId);
            }

            @Override
            public Collection<OrderDto> findByState(OrderState orderState) {
                return memory.values().stream().filter(orderDto -> orderDto.getOrderState().equals(orderState)).collect(Collectors.toList());
            }
        };

        Logistics logistics = new Logistics() {
            @Override
            public void prepareOrder(int orderId) {
                throw new UnsupportedOperationException();
            }

            @Override
            public void deliver(int orderId) {
                throw new UnsupportedOperationException();
            }
        };

        OrderFacade orderFacade = new OrderFacade(orderStore, logistics);

        FoodOrderCommandService foodOrderCommandService = orderFacade.getFoodOrderCommandService();
        FoodOrderQueryService foodOrderQueryServiceFacade = orderFacade.getFoodOrderQueryServiceFacade();

        int orderId = foodOrderCommandService.createOrder("Burger", "ul. Balonowa");
        Assertions.assertEquals(1, orderId);

        OrderDto orderDetails = foodOrderQueryServiceFacade.getOrderDetails(orderId);
        Assertions.assertEquals(OrderState.NEW, orderDetails.getOrderState());
    }

}
