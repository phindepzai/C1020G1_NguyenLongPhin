package model.service;

import model.bean.customer.Customer;
import model.bean.customer.CustomerType;

import java.util.List;

public interface CustomerService {
    void save(Customer customer);
    List<Customer> findAll(int page);
    List<CustomerType> findAllCustomerType();
    CustomerType findCustomerType(int id);
    Customer findByID(int id);
    void delete(int id);
    CustomerType getCustomerType(int id);
    int size();
    void deleteAll();
    List<Customer> findByName(String key,int page);
    int sizeName(String key);
}
