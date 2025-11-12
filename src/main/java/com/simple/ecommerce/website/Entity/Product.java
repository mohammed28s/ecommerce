package com.simple.ecommerce.website.Entity;


import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.util.List;


@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY
    )
    private Integer id;

    @Column(nullable = false, length =255)    
    private String name;

    @Column(nullable = false, precision =10,scale = 2)
    private BigDecimal price;   // Hint: the price must be BigDecimal to get accurate price

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "product",  cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Cart> carts;

}
