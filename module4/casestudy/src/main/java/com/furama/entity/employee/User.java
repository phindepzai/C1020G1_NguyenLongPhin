package com.furama.entity.employee;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class User implements Serializable {
    @Id
    private String username;
    private String password;
    @OneToOne(mappedBy = "user")
    @JsonBackReference
    private Employee employee;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<UserRole> userRoles;
}
