package com.furama.entity.contract;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.furama.annotation.EndDate;
import com.furama.annotation.StartDate;
import com.furama.entity.customer.Customer;
import com.furama.entity.employee.Employee;
import com.furama.entity.services.Services;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "start_date",columnDefinition = "date")
    @Pattern(regexp = "[0-9]{4}([/-][0-9]{2}){2}")
    @StartDate
    private String startDate;
    @Column(name = "end_date",columnDefinition = "date")
    @Pattern(regexp = "[0-9]{4}([/-][0-9]{2}){2}")
    @EndDate
    private String endDate;
    @Min(1)
    private double deposit;
    private double totalMoney;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id",referencedColumnName = "id")
    private Employee employee;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    private Customer customer;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "services_id",referencedColumnName = "id")
    private Services services;
    @OneToMany(mappedBy = "contract",cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<ContractDetail> set;
}
