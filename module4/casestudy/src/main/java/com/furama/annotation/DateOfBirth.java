package com.furama.annotation;

import com.furama.validator.DateOfBirthValidator;
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
@Constraint(validatedBy = DateOfBirthValidator.class)
@Documented
public @interface DateOfBirth {
    String message() default "Must be more than 18 years old and year must be more than 1900";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
