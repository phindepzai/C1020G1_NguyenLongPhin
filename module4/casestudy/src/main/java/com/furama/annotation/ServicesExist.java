package com.furama.annotation;

import com.furama.validator.CustomerCodeValidator;
import com.furama.validator.ServicesExistValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = ServicesExistValidator.class)
@Documented
public @interface ServicesExist {
    String message() default "Code was exist. Plz use another code";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
