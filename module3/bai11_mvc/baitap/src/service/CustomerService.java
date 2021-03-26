package service;

import bean.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    void delete(Integer id);

    Customer findById(Integer id);
}
