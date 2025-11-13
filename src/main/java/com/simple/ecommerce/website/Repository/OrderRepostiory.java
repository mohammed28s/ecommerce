package com.simple.ecommerce.website.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.simple.ecommerce.website.Entity.Order;
import com.simple.ecommerce.website.Entity.User;

@Repository
public interface OrderRepostiory extends JpaRepository<Order, Integer> {

    List<Order> findByUser(User user);

}
