package com.furama.entity.employee;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.furama.annotation.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    private String name;
    @Column(columnDefinition = "date")
    @Pattern(regexp = "[0-9]{4}([/-][0-9]{2}){2}", message = "Date of Birth must be XX/XX/XXXX (X is 0-9)")
    @DateOfBirth
    private String dateOfBirth;
    @Pattern(regexp = "[0-9]{9}([0-9]{3})?")
    @IdCardEmployee
    private String idCard;
    @Column(columnDefinition = "double")
//    @Pattern(regexp = "[1-9][0-9]*(\\.[0-9]+)?")
    @DecimalMin(value = "0.01")
    private double salary;
    @Pattern(regexp = "(84|0)(90|91)[0-9]{7}", message = "Phone must be 090XXXXXXX or 091XXXXXXX or 8490XXXXXXX or 8491XXXXXX")
    private String phone;
    @Pattern(regexp = "^[a-zA-z]\\w{6,20}[@][a-zA-Z]{2,10}([.][a-zA-Z]{2,5}){1,2}",message = "Email invalid!")
    @EmailExistEmployee
    private String email;
    @NotBlank
    private String address;
    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    @JsonManagedReference
    private Position position;
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "education_degree_id", referencedColumnName = "id")
    private EducationDegree educationDegree;
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "divion_id", referencedColumnName = "id")
    private Division division;
    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User user;
}
