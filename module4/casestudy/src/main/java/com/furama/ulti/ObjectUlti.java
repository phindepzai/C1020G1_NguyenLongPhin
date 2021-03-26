package com.furama.ulti;

import com.furama.entity.contract.Contract;
import com.furama.entity.customer.Customer;
import com.furama.entity.employee.Employee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ObjectUlti {
    private boolean isCreate;
    private Contract contract;
    private Customer customer;
    private Employee employee;
    private String startDate;
}
