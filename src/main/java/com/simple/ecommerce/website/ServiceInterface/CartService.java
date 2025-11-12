package com.simple.ecommerce.website.ServiceInterface;

import java.util.List;

import com.simple.ecommerce.website.Entity.Cart;

public interface CartService {

    List<Cart> getAllCarts();  // get all carts

    Cart getCartById(Integer cartId);  // get cart by id

    Cart saveCart(Cart cart);  // create new cart

    void deleteCart(Integer cartId); // delete cart by id

    Cart updateCart(Integer cartId, Cart cart);  // update existing cart info




}
