package org.example.hex.domain.restaurant;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.hex.domain.restaurant.port.primary.RestaurantService;
import org.example.hex.domain.restaurant.port.secondary.OrderDetails;
import org.example.hex.domain.restaurant.port.secondary.OrderNotification;
import org.example.hex.domain.restaurant.port.shared.OrderDetailsDto;

@RequiredArgsConstructor
@Slf4j
class RestaurantServiceImpl implements RestaurantService {

    private final OrderDetails orderDetails;
    private final OrderNotification orderNotification;

    @Override
    public void prepareOrder(int foodOrderId) {
        OrderDetailsDto orderDetails = this.orderDetails.getOrderDetails(foodOrderId);
        log.info("preparing dish {}", orderDetails.getDishName());
        orderNotification.orderReady(orderDetails.getFoodOrderId());
    }
}
