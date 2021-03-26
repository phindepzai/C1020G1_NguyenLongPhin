package com.furama.entity.services;

import lombok.*;

import javax.persistence.Entity;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Villa extends Services {
    @NotBlank
    private String standard;
    @NotBlank
    private String convenientDescription;
    @DecimalMin(value = "0.01")
    private double areaPool;
    @Min(1)
    private int numOfFloor;
}
