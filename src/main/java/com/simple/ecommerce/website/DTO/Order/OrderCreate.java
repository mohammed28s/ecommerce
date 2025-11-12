package com.simple.ecommerce.website.DTO.Order;




import java.util.List;

import com.simple.ecommerce.website.DTO.Cart.CartAdd;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class OrderCreate {

    @NotEmpty
    List<@Valid CartAdd> items;
}
