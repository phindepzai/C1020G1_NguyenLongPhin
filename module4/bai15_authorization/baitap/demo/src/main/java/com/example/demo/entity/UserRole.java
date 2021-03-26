package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "username")
    private User user;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
