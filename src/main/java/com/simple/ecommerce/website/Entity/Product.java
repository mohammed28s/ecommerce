package com.simple.ecommerce.website.Entity;


import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;



@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private BigDecimal price;   // Hint: the price must be BigDecimal to get accurate price

    private String description;

}
