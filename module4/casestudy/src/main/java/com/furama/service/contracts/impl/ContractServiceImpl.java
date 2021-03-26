package com.furama.service.contracts.impl;

import com.furama.entity.contract.Contract;
import com.furama.repository.contract.ContractRepository;
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

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractRepository contractRepository;

    @Override
    public void save(Contract contract) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        ObjectUlti check = MapManager.map.get(auth.getName());
        if (check.isCreate()){
            contract.setTotalMoney(setTotalMoney(contract));
        }
        contractRepository.save(contract);
    }

    private double setTotalMoney(Contract contract) {
        double money = contract.getServices().getCost() * contract.getServices().getRentType().getCost();
        int day = Check.getDate(contract.getStartDate(),contract.getEndDate());
        return money * day;
    }

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public Contract findById(int id) {
        return contractRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Contract> findAllByContractActive(String date, Pageable pageable) {
        return contractRepository.findAllByEndDateAfter(date,pageable);
    }

    @Override
    public Page<Contract> findAllByContractActiveContaining(String key, Pageable pageable) {
        return contractRepository.findAllByEndDateAfterContaining(key,pageable);
    }

    @Override
    public Page<Contract> findAllContaining(String key, Pageable pageable) {
        return contractRepository.findAllByContaining(key,pageable);
    }

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }
}
