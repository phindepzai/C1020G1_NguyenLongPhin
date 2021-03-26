package com.furama.entity.services;

import lombok.*;

import javax.persistence.Entity;
import javax.validation.constraints.Min;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Room extends Services {
    @Min(1)
    private int attachServiceFreeID;
}
