package model.service;

import model.bean.employee.*;

import java.util.List;

public interface EmployeeService {
    void save(Employee employee);
    void delete(int id);
    Employee findByID(int id);
    List<Employee> findAll(int page);
    EducationDegree findED(int id);
    Position findPosition(int id);
    Division findDivision(int id);
    User findUser(String username);
    List<Position> positionList();
    List<EducationDegree> educationList();
    List<Division> divisionList();
    List<User> userList();
    int size();
    List<Employee> findByName(String key,int page);
    int sizeName(String key);
    void saveUser(User user);
    void deleteAll();
}
