package com.simple.ecommerce.website.DTO.Order;




import java.util.List;

import com.simple.ecommerce.website.DTO.Cart.CartAddDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class OrderCreateDTO {

    @NotEmpty
    List<@Valid CartAddDTO> items;
}
