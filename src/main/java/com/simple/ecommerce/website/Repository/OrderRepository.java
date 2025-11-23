package com.simple.ecommerce.website.Repository;

import com.simple.ecommerce.website.Entity.Order;
import com.simple.ecommerce.website.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByUser(User user);
}
