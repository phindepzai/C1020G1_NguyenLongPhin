package com.furama.service.contracts;

import com.furama.entity.contract.Contract;
import com.furama.entity.contract.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContractDetailService {
    Page<ContractDetail> findByContract(Contract contract, Pageable pageable);
    Page<ContractDetail> findAll(Pageable pageable);
    void save(ContractDetail contractDetail);
    ContractDetail findById(int id);
}
