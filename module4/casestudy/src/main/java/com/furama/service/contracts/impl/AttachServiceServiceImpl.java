package com.furama.service.contracts.impl;

import com.furama.entity.contract.AttachService;
import com.furama.repository.contract.AttachServiceRepository;
import com.furama.service.contracts.AttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachServiceServiceImpl implements AttachServiceService {
    @Autowired
    private AttachServiceRepository attachServiceRepository;

    @Override
    public List<AttachService> findAll() {
        return attachServiceRepository.findAll();
    }

    @Override
    public AttachService findById(int id) {
        return attachServiceRepository.findById(id).orElse(null);
    }
}
