package com.furama.service.customers.impl;

import com.furama.entity.customer.Customer;
import com.furama.entity.customer.CustomerType;
import com.furama.repository.customer.CustomerRepository;
import com.furama.repository.customer.CustomerTypeRepository;
import com.furama.service.customers.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerTypeRepository customerTypeRepository;
    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Page<Customer> findAllByName(String key,Pageable pageable) {
        return customerRepository.findByContaining(key,pageable);
    }

    @Override
    public Customer findById(String id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public List<CustomerType> findAllCustomerType() {
        return customerTypeRepository.findAll();
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
