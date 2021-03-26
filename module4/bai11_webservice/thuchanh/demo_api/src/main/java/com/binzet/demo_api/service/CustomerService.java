package com.binzet.demo_api.service;

import com.binzet.demo_api.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Customer findById(int id);
    void save(Customer customer);
    void delete(int id);
}
