package com.binzet.customer.service;

import com.binzet.customer.entity.Customer;

import java.util.List;

public interface CustomerService {
    void save(Customer customer);
    void delete(int id);
    List<Customer> findAll();
    Customer findById(int id);
}
