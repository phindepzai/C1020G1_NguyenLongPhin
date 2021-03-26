package com.furama.annotation;

import com.furama.validator.EndDateValidator;
import com.furama.validator.StartDateValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = EndDateValidator.class)
@Documented
public @interface EndDate {
    String message() default "This services was booked or End Date you choose less than Start Date/today(if start date < today)!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

