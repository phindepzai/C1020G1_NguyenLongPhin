package com.binzet.blog.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "App_Role",uniqueConstraints = {
        @UniqueConstraint(name = "APP_ROLE_UK",columnNames = "Role_Name")
})
public class AppRole {
    @Id
    @GeneratedValue
    @Column(name = "Role_Id",nullable = false)
    private long id;
    @Column(name = "Role_Name",length = 30,nullable = false)
    private String roleName;
}
