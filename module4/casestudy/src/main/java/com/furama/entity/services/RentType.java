package com.furama.entity.services;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private double cost;
    @OneToMany(mappedBy = "rentType",cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Services> blog;
}
