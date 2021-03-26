package com.furama.service.contracts;

import com.furama.entity.contract.AttachService;

import java.util.List;

public interface AttachServiceService {
    List<AttachService> findAll();
    AttachService findById(int id);
}
