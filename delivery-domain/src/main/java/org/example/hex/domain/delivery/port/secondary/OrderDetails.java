package org.example.hex.domain.delivery.port.secondary;

import org.example.hex.domain.delivery.port.shared.OrderDetailsDto;

public interface OrderDetails {
    OrderDetailsDto getOrderDetails(int orderId);
}
