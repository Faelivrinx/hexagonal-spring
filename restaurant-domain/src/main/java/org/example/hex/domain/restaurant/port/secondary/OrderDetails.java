package org.example.hex.domain.restaurant.port.secondary;

import org.example.hex.domain.restaurant.port.shared.OrderDetailsDto;

public interface OrderDetails {
    OrderDetailsDto getOrderDetails(int foodOrderId);
}
