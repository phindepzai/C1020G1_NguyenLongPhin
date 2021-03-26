package model.repository;

import model.bean.customer.Customer;
import model.bean.employee.*;

import java.util.List;

public interface EmployeeRepository {
    void save(Employee employee);
    List<Employee> findAll();
    Employee findByID(int id);
    void delete(int id);
    Position findPosition(int id);
    EducationDegree findEducationDegree(int id);
    Division findDivision(int id);
    User findUser(String username);
    List<Position> listPosition();
    List<EducationDegree> listED();
    List<Division> listDivion();
    List<User> listUser();
    List<Employee> findByName(String key);
    void saveUser(User user);
}
