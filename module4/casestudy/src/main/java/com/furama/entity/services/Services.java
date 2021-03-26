package com.furama.entity.services;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.furama.annotation.ServicesExist;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Services {
    @Id
    @Pattern(regexp = "(DV-)[0-9]{4}",message = "Code must be DV-XXXX (X is 0-9)")
    @ServicesExist
    private String id;
    @NotBlank
    private String name;
    @DecimalMin(value = "0.01")
    private double area;
    @Min(1)
    private int cost;
    @Column(name = "quantity_max")
    @Min(1)
    private int quantityMax;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "services_type_id",referencedColumnName = "id")
    @JsonManagedReference
    private ServicesType servicesType;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rent_type_id",referencedColumnName = "id")
    @JsonManagedReference
    private RentType rentType;
}
