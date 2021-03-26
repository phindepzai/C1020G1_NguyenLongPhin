package com.furama.repository.contract;

import com.furama.entity.contract.Contract;
import com.furama.entity.contract.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractDetailRepository extends JpaRepository<ContractDetail,Integer> {
    Page<ContractDetail> findAllByContract(Contract contract, Pageable pageable);
}
