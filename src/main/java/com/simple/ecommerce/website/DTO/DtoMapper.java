package com.simple.ecommerce.website.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.simple.ecommerce.website.DTO.Cart.CartItem;
import com.simple.ecommerce.website.DTO.Order.OrderResponse;
import com.simple.ecommerce.website.DTO.Product.ProductResponse;
import com.simple.ecommerce.website.DTO.User.UserResponse;
import com.simple.ecommerce.website.Entity.Order;
import com.simple.ecommerce.website.Entity.Product;
import com.simple.ecommerce.website.Entity.User;

public class DtoMapper {

    // Product
    public static ProductResponse toResponse(Product p) {
        return new ProductResponse(
            p.getId(),
            p.getName(),
            p.getDescription(),
            p.getPrice()
        );
    }

    // User
    public static UserResponse toResponse(User u) {
        return new UserResponse(
            u.getId(),
            u.getUsername()
        );
    }

    // Cart / Item
    public static CartItem toCartItem(Product p, Integer quantity) {
        BigDecimal sub = p.getPrice().multiply(BigDecimal.valueOf(quantity));
        return new CartItem(
            DtoMapper.toResponse(p),
            quantity,
            sub
        );
    }

    // Order
    public static OrderResponse toResponse(Order o, List<CartItem> lines) {
        return new OrderResponse(
            o.getId(),
            o.getUser().getId(),
            o.getTotal(),
            o.getStatus(),
            LocalDateTime.now(),
            lines
        );
    }
    
}
