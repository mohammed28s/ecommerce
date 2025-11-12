package com.simple.ecommerce.website.DTO.Order;





import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.simple.ecommerce.website.DTO.Cart.CartItem;
import com.simple.ecommerce.website.Enum.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class OrderResponse {

    private Integer id;

    private Integer userId;

    private BigDecimal total;

    private OrderStatus status;

    private LocalDateTime createdAt;

    private List<CartItem> items; // detailed lines

}
