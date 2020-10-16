package org.example.hex.domain.order.port.primary;


public interface FoodOrderCommandService {

    int createOrder(String dishName, String address);

    void markAsReadyToDelivery(int orderId);

    void markAsDelivered(int orderId);

    void makeOrders();

}
