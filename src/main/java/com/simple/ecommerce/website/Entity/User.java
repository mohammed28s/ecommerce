package com.simple.ecommerce.website.Entity;



import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String username;

    private String password;   // This is must be hashed

    @OneToMany(mappedBy = "User")
    private List<Cart> carts;

    @OneToMany(mappedBy = "User")
    private List<Order> orders;


}
