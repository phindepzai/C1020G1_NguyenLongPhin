package com.furama.service.employees.impl;

import com.furama.entity.employee.*;
import com.furama.repository.employee.*;
import com.furama.service.employees.EmployeePropertyService;
import com.furama.service.employees.EmployeeService;
import com.furama.ulti.Check;
import com.furama.ulti.MapManager;
import com.furama.ulti.ObjectUlti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeePropertyServiceImpl implements EmployeePropertyService {
    @Autowired
    private PositionRepository positionRepository;
    @Autowired
    private DivisionRepository divisionRepository;
    @Autowired
    private EducationDegreeRepository educationDegreeRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmployeeService employeeService;
    @Override
    public List<Position> findAllPosition() {
        return positionRepository.findAll();
    }

    @Override
    public List<EducationDegree> findAllEducationDegree() {
        return educationDegreeRepository.findAll();
    }

    @Override
    public List<Division> findAllDivision() {
        return divisionRepository.findAll();
    }

    @Override
    public void setUser(Employee employee, String password) {
        User user;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        ObjectUlti check = MapManager.map.get(auth.getName());
        if (check.isCreate()){
            user = new User();
            user.setUsername(employee.getEmail());
            user.setPassword(new BCryptPasswordEncoder().encode(password));
            userRepository.save(user);
        } else {
            user = userRepository.findByUsername(employee.getEmail());
            for (UserRole u:userRoleRepository.findAllByUser(user)) {
                userRoleRepository.delete(u);
            }
        }
        Position position = employee.getPosition();
        Role role;
        if (position.getId() == 5 || position.getId() == 6){
            role = roleRepository.findById(1).orElse(null);
        } else {
            role = roleRepository.findById(2).orElse(null);
        }
        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        userRoleRepository.save(userRole);
        employee.setUser(userRepository.findByUsername(employee.getEmail()));
        employeeService.save(employee);
    }
}
