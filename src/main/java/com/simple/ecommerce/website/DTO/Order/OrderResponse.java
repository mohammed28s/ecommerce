package com.simple.ecommerce.website.DTO.Order;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.simple.ecommerce.website.DTO.Cart.CartItem;
import com.simple.ecommerce.website.DTO.User.UserResponse;
import com.simple.ecommerce.website.Enum.OrderStatus;

public class OrderResponse {

    Integer id;

    UserResponse userId;

    BigDecimal total;

    OrderStatus status;

    LocalDateTime createdAt;

    List<CartItem> items; // detailed lines

}
