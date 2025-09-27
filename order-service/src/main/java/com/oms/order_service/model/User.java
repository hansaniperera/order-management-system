package com.oms.order_service.model;
import jakarta.persistence.*;

@Entity
@Table(name = "app_user") // rename table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public User() {}

}

