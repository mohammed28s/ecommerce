//package com.simple.ecommerce.website.Entity;
//
//
//import jakarta.persistence.*;
//import lombok.Data;
//import java.math.BigDecimal;
//
//
//
//@Data
//@Entity
//@Table(name = "orders")
//public class Order {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Integer id;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
//
//    private BigDecimal total;
//
//    private String status;
//
//
//
//}
