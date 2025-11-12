package com.simple.ecommerce.website.DTO.Cart;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class CartAdd {

    @Positive
    Integer productId;

    @Positive
    Integer quantity;

}
