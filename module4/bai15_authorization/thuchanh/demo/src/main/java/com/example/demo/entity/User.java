package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "APP_USER_UK",columnNames = "username")
})
public class User {
    @Id
    private String username;
    private String password;
}
