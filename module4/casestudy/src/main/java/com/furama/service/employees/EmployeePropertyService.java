package com.furama.service.employees;

import com.furama.entity.employee.Division;
import com.furama.entity.employee.EducationDegree;
import com.furama.entity.employee.Employee;
import com.furama.entity.employee.Position;

import java.util.List;

public interface EmployeePropertyService {
    List<Position> findAllPosition();
    List<EducationDegree> findAllEducationDegree();
    List<Division> findAllDivision();
    void setUser(Employee employee,String password);
}
