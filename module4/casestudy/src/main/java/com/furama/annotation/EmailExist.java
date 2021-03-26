package com.furama.annotation;

import com.furama.validator.EmailExistValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = EmailExistValidator.class)
@Documented
public @interface EmailExist {
    String message() default "Email was exist. Plz use another Email";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}