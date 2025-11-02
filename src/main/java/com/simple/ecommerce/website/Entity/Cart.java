package com.simple.ecommerce.website.Entity;


import jakarta.persistence.*;
import lombok.Data;



@Data
@Entity
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue
    private Integer id;

    @OneToMany
    @JoinColumn(table = "users", referencedColumnName = "id")
    private Integer user_id;

    @OneToMany
    @JoinColumn(table = "products", referencedColumnName = "id")
    private Integer product_id;

    private Integer quantity;



}
