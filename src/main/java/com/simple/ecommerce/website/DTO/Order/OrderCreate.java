package com.simple.ecommerce.website.DTO.Order;

import java.util.List;

import com.simple.ecommerce.website.DTO.Cart.CartAdd;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

public class OrderCreate {

    @NotEmpty
    List<@Valid CartAdd> items;
}
