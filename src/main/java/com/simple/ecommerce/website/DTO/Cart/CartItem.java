package com.simple.ecommerce.website.DTO.Cart;




import java.math.BigDecimal;

import com.simple.ecommerce.website.DTO.Product.ProductResponse;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class CartItem {

    private ProductResponse product;
    private Integer quantity;
    private BigDecimal subTotal;

    
}
