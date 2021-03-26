package com.furama.entity.employee;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "ROLE_UK",columnNames = "name")
})
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "role",cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<UserRole> userRoles;
}
