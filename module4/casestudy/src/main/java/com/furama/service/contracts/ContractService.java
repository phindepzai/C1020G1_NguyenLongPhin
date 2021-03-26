package com.furama.service.contracts;

import com.furama.entity.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContractService {
    void save(Contract contract);
    Page<Contract> findAll(Pageable pageable);
    Contract findById(int id);
    Page<Contract> findAllByContractActive(String date,Pageable pageable);
    Page<Contract> findAllByContractActiveContaining(String key,Pageable pageable);
    List<Contract> findAll();
    Page<Contract> findAllContaining(String key,Pageable pageable);
}
