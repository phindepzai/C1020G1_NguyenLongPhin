package model.service.impl;

import model.bean.customer.Customer;
import model.bean.customer.CustomerType;
import model.repository.CustomerRepository;
import model.repository.impl.CustomerRepositoryImpl;
import model.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository = new CustomerRepositoryImpl();

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public List<Customer> findAll(int page) {
        List<Customer> list = new ArrayList<>();
        int start = (page - 1) * 7;
        int end;
        List<Customer> listAll = customerRepository.findAll();
        if (page * 7 > listAll.size()) {
            end = listAll.size();
        } else {
            end = page * 7;
        }
        for (int i = start; i < end; i++) {
            list.add(listAll.get(i));
        }
        return list;
    }

    @Override
    public List<CustomerType> findAllCustomerType() {
        return customerRepository.findAllCustomerType();
    }

    @Override
    public CustomerType findCustomerType(int id) {
        return customerRepository.findCustomerType(id);
    }

    @Override
    public Customer findByID(int id) {
        return customerRepository.findByID(id);
    }

    @Override
    public void delete(int id) {
        customerRepository.delete(id);
    }

    @Override
    public CustomerType getCustomerType(int id) {
        return customerRepository.findCustomerType(id);
    }

    @Override
    public int size() {
        return customerRepository.findAll().size();
    }

    @Override
    public void deleteAll() {
        for (Customer customer : customerRepository.findAll()) {
            delete(customer.getId());
        }
    }

    @Override
    public List<Customer> findByName(String key,int page) {
        List<Customer> list = new ArrayList<>();
        int start = (page - 1) * 7;
        int end;
        List<Customer> listAll = customerRepository.findByName(key);
        if (page * 7 > listAll.size()) {
            end = listAll.size();
        } else {
            end = page * 7;
        }
        for (int i = start; i < end; i++) {
            list.add(listAll.get(i));
        }
        return list;
    }

    @Override
    public int sizeName(String key) {
        return customerRepository.findByName(key).size();
    }
}
