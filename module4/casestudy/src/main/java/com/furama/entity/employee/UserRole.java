package com.furama.entity.employee;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "username",referencedColumnName = "username")
    @JsonManagedReference
    private User user;
    @ManyToOne
    @JoinColumn(name = "role_id",referencedColumnName = "id")
    @JsonManagedReference
    private Role role;
}
