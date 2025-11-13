package com.simple.ecommerce.website.ServiceInterface;




import java.util.List;

import com.simple.ecommerce.website.DTO.Order.OrderCreateDTO;
import com.simple.ecommerce.website.DTO.Order.OrderResponseDTO;


public interface OrderService {

    OrderResponseDTO createOrder(Integer userId, OrderCreateDTO dto);

    List<OrderResponseDTO> getMyOrders(Integer userId);

    OrderResponseDTO getOrder(Integer userId, Integer orderId);
}
