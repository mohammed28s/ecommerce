package com.simple.ecommerce.website.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.simple.ecommerce.website.Entity.Order;

@Repository
public interface OrderRepostiory extends JpaRepository<Order, Integer> {



}
