package com.simple.ecommerce.website.DTO.Cart;

import jakarta.validation.constraints.Positive;

public class CartAdd {

    @Positive
    Integer productId;

    @Positive
    Integer quantity;

}
