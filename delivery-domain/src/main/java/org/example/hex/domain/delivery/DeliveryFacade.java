package org.example.hex.domain.delivery;

import lombok.Getter;
import org.example.hex.domain.delivery.port.primary.DeliveryService;
import org.example.hex.domain.delivery.port.secondary.OrderDetails;
import org.example.hex.domain.delivery.port.secondary.OrderNotification;

@Getter
public class DeliveryFacade {

    private final DeliveryService deliveryService;

    public DeliveryFacade(OrderDetails orderDetails, OrderNotification orderNotification) {
        this.deliveryService = new DeliveryServiceImpl(orderDetails, orderNotification);
    }
}
