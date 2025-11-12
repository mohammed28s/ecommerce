package com.simple.ecommerce.website.Entity;


import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

import com.simple.ecommerce.website.Enum.OrderStatus;



@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false, precision = 
    10, scale = 2)
    private BigDecimal total;

    @Enumerated(EnumType.STRING)
    @Column(length = 50, nullable = false)
    private OrderStatus status;



}
