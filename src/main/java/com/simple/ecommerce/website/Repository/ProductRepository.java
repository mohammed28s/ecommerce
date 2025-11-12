package com.simple.ecommerce.website.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simple.ecommerce.website.Entity.Product;



@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    
}
