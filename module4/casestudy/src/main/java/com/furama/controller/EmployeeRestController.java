package com.furama.controller;

import com.furama.entity.employee.Employee;
import com.furama.service.employees.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/employees")
public class EmployeeRestController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/search")
    public ResponseEntity<Page<Employee>> search(@RequestParam(required = false) String key,@PageableDefault(size = 5) Pageable pageable){
        if (key == null){
            key = "";
        }
        pageable = pageable.previousOrFirst();
        Page<Employee> employees = employeeService.findByNameContaining(key, pageable);
        return new ResponseEntity<Page<Employee>>(employees, HttpStatus.OK);
    }
}
