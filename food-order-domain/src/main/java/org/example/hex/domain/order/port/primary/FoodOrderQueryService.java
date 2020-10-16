package org.example.hex.domain.order.port.primary;

import org.example.hex.domain.order.port.shared.OrderDto;

public interface FoodOrderQueryService {

    OrderDto getOrderDetails(int orderId); //query

}
