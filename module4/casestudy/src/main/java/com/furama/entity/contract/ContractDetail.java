package com.furama.entity.contract;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "contract_detail")
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "contract_id",referencedColumnName = "id")
    @JsonManagedReference
    private Contract contract;
    @ManyToOne
    @JoinColumn(name = "attach_service_id",referencedColumnName = "id")
    private AttachService attachService;
    @Min(1)
    private int quantity;
}
