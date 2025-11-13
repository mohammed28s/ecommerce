package com.simple.ecommerce.website.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.simple.ecommerce.website.DTO.Cart.CartItemDTO;
import com.simple.ecommerce.website.DTO.Order.OrderResponseDTO;
import com.simple.ecommerce.website.DTO.Product.ProductResponseDTO;
import com.simple.ecommerce.website.DTO.User.UserResponseDTO;
import com.simple.ecommerce.website.Entity.Order;
import com.simple.ecommerce.website.Entity.Product;
import com.simple.ecommerce.website.Entity.User;

public class DtoMapper {

    // Product
    public static ProductResponseDTO toResponse(Product p) {
        return new ProductResponseDTO(
            p.getId(),
            p.getName(),
            p.getDescription(),
            p.getPrice()
        );
    }

    // User
    public static UserResponseDTO toResponse(User u) {
        return new UserResponseDTO(
            u.getId(),
            u.getUsername()
        );
    }

    // Cart / Item
    public static CartItemDTO toCartItem(Product p, Integer quantity) {
        BigDecimal sub = p.getPrice().multiply(BigDecimal.valueOf(quantity));
        return new CartItemDTO(
            DtoMapper.toResponse(p),
            quantity,
            sub
        );
    }

    // Order
    public static OrderResponseDTO toResponse(Order o, List<CartItemDTO> lines) {
        return new OrderResponseDTO(
            o.getId(),
            o.getUser().getId(),
            o.getTotal(),
            o.getStatus(),
            LocalDateTime.now(),
            lines
        );
    }
    
}
