package com.simple.ecommerce.website.DTO.Cart;




import java.math.BigDecimal;

import com.simple.ecommerce.website.DTO.Product.ProductResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class CartItemDTO {

    private ProductResponseDTO product;
    private Integer quantity;
    private BigDecimal subTotal;

    
}
