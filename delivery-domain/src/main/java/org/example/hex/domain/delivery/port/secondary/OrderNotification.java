package org.example.hex.domain.delivery.port.secondary;

public interface OrderNotification {
    void orderDelivered(int orderId);
}
