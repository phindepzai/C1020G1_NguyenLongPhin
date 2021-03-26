package com.furama.validator;

import com.furama.annotation.EndDate;
import com.furama.entity.contract.Contract;
import com.furama.service.contracts.ContractService;
import com.furama.ulti.Check;
import com.furama.ulti.MapManager;
import com.furama.ulti.ObjectUlti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EndDateValidator implements ConstraintValidator<EndDate, String> {
   @Autowired
   private ContractService contractService;

   public void initialize(EndDate constraint) {
   }

   public boolean isValid(String obj, ConstraintValidatorContext context) {
      String start;
      Authentication auth = SecurityContextHolder.getContext().getAuthentication();
      ObjectUlti check = MapManager.map.get(auth.getName());
      if (check.getStartDate() == null){
         start = Check.getToday();
      } else {
         start = check.getStartDate();
      }
      return Check.getDate(start, obj) >= 1;
   }
}
