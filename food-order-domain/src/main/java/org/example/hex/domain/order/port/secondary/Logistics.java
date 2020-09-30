package org.example.hex.domain.order.port.secondary;

public interface Logistics {

    void prepareOrder(int orderId);

    void deliver(int orderId);

}
