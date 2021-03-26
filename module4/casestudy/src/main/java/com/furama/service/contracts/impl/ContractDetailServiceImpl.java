package com.furama.service.contracts.impl;

import com.furama.entity.contract.Contract;
import com.furama.entity.contract.ContractDetail;
import com.furama.repository.contract.ContractDetailRepository;
import com.furama.service.contracts.ContractDetailService;
import com.furama.service.contracts.ContractService;
import com.furama.ulti.Check;
import com.furama.ulti.MapManager;
import com.furama.ulti.ObjectUlti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class ContractDetailServiceImpl implements ContractDetailService {
    @Autowired
    private ContractDetailRepository contractDetailRepository;
    @Autowired
    private ContractService contractService;

    @Override
    public Page<ContractDetail> findByContract(Contract contract, Pageable pageable) {
        return contractDetailRepository.findAllByContract(contract, pageable);
    }

    @Override
    public Page<ContractDetail> findAll(Pageable pageable) {
        return contractDetailRepository.findAll(pageable);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        Contract contract = contractDetail.getContract();
        double total = contract.getTotalMoney() + (contractDetail.getAttachService().getCost() * contractDetail.getQuantity());
        contract.setTotalMoney(total);
        contractService.save(contract);
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public ContractDetail findById(int id) {
        return contractDetailRepository.findById(id).orElse(null);
    }
}
