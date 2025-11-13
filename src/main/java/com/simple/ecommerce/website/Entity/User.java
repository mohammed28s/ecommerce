package com.simple.ecommerce.website.Entity;



import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY
    )
    private Integer id;

    @Column(nullable = false, unique = true, length = 255)
    private String username;

    @Column(nullable = false, length = 255)
    private String password;   // This is must be hashed

    
    @OneToMany(mappedBy = "user")
    private List<Cart> carts;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;


}
