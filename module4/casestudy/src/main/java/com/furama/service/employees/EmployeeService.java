package com.furama.service.employees;

import com.furama.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    void save(Employee employee);
    void delete(int id);
    Page<Employee> findAll(Pageable pageable);
    Page<Employee> findByNameContaining(String key,Pageable pageable);
    Employee findById(int id);
    List<Employee> findAll();
    Employee findByEmail(String email);
}
