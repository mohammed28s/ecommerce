package com.simple.ecommerce.website.ServiceInterface;




import java.util.List;

import com.simple.ecommerce.website.Entity.Order;


public interface OrderService {

    List<Order> getOrdersByUserId(Integer userId);  // get all order ids by user id

    Order getOrderById(Integer orderId);  // get order by order id

    Order saveOrder(Order order);  // create new order

    void deleteOrder(Integer orderId); // delete order by id

    Order updateOrder(Integer orderId, Order order);  // updated order info

}
