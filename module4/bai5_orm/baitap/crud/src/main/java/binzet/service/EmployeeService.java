package binzet.service;

import binzet.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
    void save(Employee employee);
    void delete(int id);
    void deleteAll();
    List<Employee> findAll();
    Employee findById(int id);
}
