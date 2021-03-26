package com.furama.entity.customer;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.furama.annotation.CustomerCodeExist;
import com.furama.annotation.DateOfBirth;
import com.furama.annotation.EmailExist;
import com.furama.annotation.IdCard;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Customer {
    @Id
    @Pattern(regexp = "(KH-)[0-9]{4}",message = "Code must be KH-XXXX (X is 0-9)")
    @CustomerCodeExist
    private String id;
    @NotBlank
    private String name;
    @ManyToOne
    @JoinColumn(name = "customer_type_id",referencedColumnName = "id")
    @JsonManagedReference
    private CustomerType customerType;
    @Column(columnDefinition = "date")
    @Pattern(regexp = "[0-9]{4}([/-][0-9]{2}){2}",message = "Date of Birth must be XX/XX/XXXX (X is 0-9)")
    @DateOfBirth
    private String dateOfBirth;
    @Pattern(regexp = "((Male)|(Female)|(Other))")
    private String gender;
    @Pattern(regexp = "[0-9]{9}([0-9]{3})?")
    @IdCard
    private String idCard;
    @Pattern(regexp = "(84|0)(90|91)[0-9]{7}",message = "Phone must be 090XXXXXXX or 091XXXXXXX or 8490XXXXXXX or 8491XXXXXX")
    private String phone;
    @Pattern(regexp = "^[a-zA-z]\\w{6,20}[@][a-zA-Z]{2,10}([.][a-zA-Z]{2,5}){1,2}",message = "Email invalid!")
    @EmailExist
    private String email;
    @NotBlank
    private String address;
}
