package com.furama.entity.contract;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.furama.entity.customer.Customer;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "attach_service")
public class AttachService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private double cost;
    private String unit;
    private String status;
    @OneToMany(mappedBy = "attachService",cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<ContractDetail> set;

}
