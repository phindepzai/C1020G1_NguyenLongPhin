package repository;

import bean.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();

    void save(Customer customer);

    void delete(Integer id);

    Customer findById(Integer id);
}
