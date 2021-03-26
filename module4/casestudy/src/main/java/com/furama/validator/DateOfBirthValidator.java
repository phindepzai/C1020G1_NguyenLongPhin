package com.furama.validator;

import com.furama.annotation.DateOfBirth;
import com.furama.ulti.Check;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateOfBirthValidator implements ConstraintValidator<DateOfBirth, String> {
   public void initialize(DateOfBirth constraint) {
   }

   public boolean isValid(String obj, ConstraintValidatorContext context) {
       return Check.checkDate(obj);
   }
}
