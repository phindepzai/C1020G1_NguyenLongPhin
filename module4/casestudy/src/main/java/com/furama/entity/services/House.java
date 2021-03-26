package com.furama.entity.services;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Getter
@Setter
@Entity
@OnDelete(action = OnDeleteAction.CASCADE)
public class House extends Services {
    @NotBlank
    private String standard;
    @NotBlank
    private String convenientDescription;
    @Min(1)
    private int numOfFloor;
}
