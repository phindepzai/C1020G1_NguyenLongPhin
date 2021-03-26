package com.furama.service.customers;

import com.furama.entity.customer.Customer;
import com.furama.entity.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    void save(Customer customer);
    void delete(String id);
    Page<Customer> findAll(Pageable pageable);
    Page<Customer> findAllByName(String key,Pageable pageable);
    Customer findById(String id);
    List<CustomerType> findAllCustomerType();
    List<Customer> findAll();
}
