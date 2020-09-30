package org.example.hex.domain.restaurant;

import lombok.Getter;
import org.example.hex.domain.restaurant.port.primary.RestaurantService;
import org.example.hex.domain.restaurant.port.secondary.OrderDetails;
import org.example.hex.domain.restaurant.port.secondary.OrderNotification;

@Getter
public class RestaurantFacade {

    private final RestaurantService restaurantService;

    public RestaurantFacade(OrderDetails orderDetails, OrderNotification orderNotification) {
        this.restaurantService = new RestaurantServiceImpl(orderDetails, orderNotification);
    }
}
