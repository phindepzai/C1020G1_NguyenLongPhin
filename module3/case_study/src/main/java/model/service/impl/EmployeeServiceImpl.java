package model.service.impl;

import model.bean.employee.*;
import model.repository.EmployeeRepository;
import model.repository.impl.EmployeeRepositoryImpl;
import model.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void delete(int id) {
        employeeRepository.delete(id);
    }

    @Override
    public Employee findByID(int id) {
        return employeeRepository.findByID(id);
    }

    @Override
    public List<Employee> findAll(int page) {
        List<Employee> list = new ArrayList<>();
        int start = (page - 1) * 7;
        int end;
        List<Employee> listAll = employeeRepository.findAll();
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
    public EducationDegree findED(int id) {
        return employeeRepository.findEducationDegree(id);
    }

    @Override
    public Position findPosition(int id) {
        return employeeRepository.findPosition(id);
    }

    @Override
    public Division findDivision(int id) {
        return employeeRepository.findDivision(id);
    }

    @Override
    public User findUser(String username) {
        return employeeRepository.findUser(username);
    }

    @Override
    public List<Position> positionList() {
        return employeeRepository.listPosition();
    }

    @Override
    public List<EducationDegree> educationList() {
        return employeeRepository.listED();
    }

    @Override
    public List<Division> divisionList() {
        return employeeRepository.listDivion();
    }

    @Override
    public List<User> userList() {
        return employeeRepository.listUser();
    }

    @Override
    public int size() {
        return employeeRepository.findAll().size();
    }

    @Override
    public List<Employee> findByName(String key, int page) {
        List<Employee> list = new ArrayList<>();
        int start = (page - 1) * 7;
        int end;
        List<Employee> listAll = employeeRepository.findByName(key);
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
        return employeeRepository.findByName(key).size();
    }

    @Override
    public void saveUser(User user) {
        employeeRepository.saveUser(user);
    }

    @Override
    public void deleteAll() {
        for (Employee element : employeeRepository.findAll()) {
            delete(element.getId());
        }
    }


}
