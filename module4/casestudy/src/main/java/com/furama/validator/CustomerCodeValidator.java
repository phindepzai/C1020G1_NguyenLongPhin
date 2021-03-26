package com.furama.validator;

import com.furama.annotation.CustomerCodeExist;
import com.furama.entity.customer.Customer;
import com.furama.service.customers.CustomerService;
import com.furama.service.customers.impl.CustomerServiceImpl;
import com.furama.ulti.Check;
import com.furama.ulti.MapManager;
import com.furama.ulti.ObjectUlti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class CustomerCodeValidator implements ConstraintValidator<CustomerCodeExist, String> {
    @Autowired
    private CustomerService customerService;

    public void initialize(CustomerCodeExist constraint) {
    }

    public boolean isValid(String obj, ConstraintValidatorContext context) {
        List<Customer> list = customerService.findAll();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        ObjectUlti check = MapManager.map.get(auth.getName());
        if (check.isCreate()){
            return customerService.findById(obj) == null;
        }
        return true;
    }
}
