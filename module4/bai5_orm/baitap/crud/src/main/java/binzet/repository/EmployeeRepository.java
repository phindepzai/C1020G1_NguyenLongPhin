package binzet.repository;

import binzet.entity.Employee;

import java.util.List;

public interface EmployeeRepository {
    void save(Employee employee);
    void delete(int id);
    void deleteAll();
    List<Employee> findAll();
    Employee findById(int id);
}
