package org.example.hex.domain.order;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.example.hex.domain.order.shared.OrderDto;
import org.example.hex.domain.order.shared.OrderState;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
class Order {
    private int orderId;
    private String dishName;
    private OrderState orderState;


    static class OrderFactor {

        private static final AtomicInteger SEQUENCE = new AtomicInteger();

        private final OrderMapper orderMapper = Mappers.getMapper(OrderMapper.class);

        @Getter
        private static final OrderFactor instance = new OrderFactor();

        Order createOrder(String dishName){
            return new Order(SEQUENCE.incrementAndGet(), dishName, OrderState.NEW);
        }

        Order from(OrderDto orderDto){
            return orderMapper.toOrder(orderDto);
        }

        OrderDto toOrderDto(Order order){
            return orderMapper.toOrderDto(order);
        }

        @Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
        interface OrderMapper {

            OrderDto toOrderDto(Order order);

            Order toOrder(OrderDto orderDto);

        }
    }
}
