package com.binzet.service;

import com.binzet.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    List<Customer> findAll();
    Customer findById(long id);
    void save(Customer customer);
    void delete(long id);
}
