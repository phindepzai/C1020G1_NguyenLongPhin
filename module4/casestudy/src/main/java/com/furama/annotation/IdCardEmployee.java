package com.furama.annotation;

import com.furama.validator.IdCardEmployeeExistValidator;
import com.furama.validator.IdCardExistValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = IdCardEmployeeExistValidator.class)
@Documented
public @interface IdCardEmployee {
    String message() default "IDCard was exist. Plz use another IDCard";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}