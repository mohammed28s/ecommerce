package com.simple.ecommerce.website.ServiceInterface;

import java.util.List;

import com.simple.ecommerce.website.DTO.Cart.CartAddDTO;
import com.simple.ecommerce.website.DTO.Cart.CartItemDTO;


public interface CartService {

    CartItemDTO addItem(Integer userId, CartAddDTO dto); // add or create new item

    List<CartItemDTO> getCart(Integer userId);  // get all the carts for the specific user

    void removeItem(Integer userId, Integer productId); // remove the item for the specific user

    void clearCart(Integer userId); // remove cart or item

}
