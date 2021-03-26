package com.furama.validator;

import com.furama.annotation.IdCard;
import com.furama.entity.customer.Customer;
import com.furama.service.customers.CustomerService;
import com.furama.ulti.Check;
import com.furama.ulti.MapManager;
import com.furama.ulti.ObjectUlti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class IdCardExistValidator implements ConstraintValidator<IdCard, String> {
   @Autowired
   private CustomerService customerService;

   public void initialize(IdCard constraint) {
   }

   public boolean isValid(String obj, ConstraintValidatorContext context) {
      Authentication auth = SecurityContextHolder.getContext().getAuthentication();
      ObjectUlti check = MapManager.map.get(auth.getName());
      if (!check.isCreate()){
         if (!check.getCustomer().getIdCard().equals(obj)){
            check.setCreate(true);
         }
      }
      if (check.isCreate()){
         for (Customer customer:customerService.findAll()) {
            if (customer.getIdCard().equals(obj)){
               if (check.getCustomer().getId() != null){
                  check.setCreate(false);
               }
               return false;
            }
         }
      }
      return true;
   }
}
