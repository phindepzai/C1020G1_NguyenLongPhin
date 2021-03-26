package com.furama.validator;

import com.furama.annotation.EmailExistEmployee;
import com.furama.entity.customer.Customer;
import com.furama.entity.employee.Employee;
import com.furama.service.employees.EmployeeService;
import com.furama.ulti.Check;
import com.furama.ulti.MapManager;
import com.furama.ulti.ObjectUlti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailExistEmployeeValidator implements ConstraintValidator<EmailExistEmployee, String> {
    @Autowired
    private EmployeeService employeeService;

    public void initialize(EmailExistEmployee constraint) {
    }

    public boolean isValid(String obj, ConstraintValidatorContext context) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        ObjectUlti check = MapManager.map.get(auth.getName());
        if (!check.isCreate()){
            if (!check.getEmployee().getEmail().equals(obj)){
                check.setCreate(true);
            }
        }
        if (check.isCreate()){
            for (Employee employee :employeeService.findAll()) {
                if (employee.getEmail().equals(obj)){
                    if (check.getEmployee().getId() != null){
                        check.setCreate(false);
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
