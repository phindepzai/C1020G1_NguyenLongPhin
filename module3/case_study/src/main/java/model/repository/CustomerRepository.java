package model.repository;

import model.bean.customer.Customer;
import model.bean.customer.CustomerType;

import java.util.List;

public interface CustomerRepository {
    void save(Customer customer);
    List<Customer> findAll();
    List<CustomerType> findAllCustomerType();
    CustomerType findCustomerType(int id);
    Customer findByID(int id);
    void delete(int id);
    List<Customer> findByName(String key);
}
