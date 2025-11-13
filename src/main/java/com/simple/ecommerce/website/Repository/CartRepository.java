package com.simple.ecommerce.website.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simple.ecommerce.website.Entity.Cart;
import com.simple.ecommerce.website.Entity.Product;
import com.simple.ecommerce.website.Entity.User;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    Optional<Cart> findByUserAndProduct(User user, Product product);

    List<Cart> findByUser(User user);

    void deleteByUserAndProduct(User user, Product product);

    void deleteByUser(User user);

}
