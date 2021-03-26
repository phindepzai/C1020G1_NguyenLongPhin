package com.binzet.form_regis.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
@Entity
public class User {
    @Size(min = 5,max = 45)
    private String firstname;
    @Size(min = 5,max = 45)
    private String lastname;
    @Pattern(regexp = "(\\+84|0)[0-9]{9}")
    private String phone;
    @Min(18)
    @Positive(message = "positive")
    @Value("${1}")
    private int age;
    @Id
    @Pattern(regexp = "^[a-zA-z]\\w{6,20}[@][a-zA-Z]{2,10}([.][a-zA-Z]{2,5}){1,2}")
    private String email;
}
