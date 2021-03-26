package com.furama.service.services;

import com.furama.entity.services.RentType;
import com.furama.entity.services.Villa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface VillaService {
    void save(Villa villa);
    void delete(Villa villa);
    Page<Villa> findAll(Pageable pageable);
    Villa findById(String id);
    Page<Villa> findAllByKey(String key,Pageable pageable);
    List<Villa> findAll();
}
