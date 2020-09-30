package org.example.hex.domain.delivery;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.hex.domain.delivery.port.primary.DeliveryService;
import org.example.hex.domain.delivery.port.secondary.OrderDetails;
import org.example.hex.domain.delivery.port.secondary.OrderNotification;
import org.example.hex.domain.delivery.port.shared.OrderDetailsDto;

@RequiredArgsConstructor
@Slf4j
class DeliveryServiceImpl implements DeliveryService {

    private final OrderDetails orderDetails;
    private final OrderNotification orderNotification;

    @Override
    public void deliveryOrder(int orderId) {
        OrderDetailsDto orderDetails = this.orderDetails.getOrderDetails(orderId);
        log.info("Delivering orderId {} to {}", orderDetails.getFoodOrderId(), orderDetails.getAddress());
        orderNotification.orderDelivered(orderDetails.getFoodOrderId());
    }
}
