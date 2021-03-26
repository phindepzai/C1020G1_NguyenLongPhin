package com.furama.service.services.impl;

import com.furama.entity.services.RentType;
import com.furama.entity.services.Villa;
import com.furama.repository.services.RentTypeRepository;
import com.furama.repository.services.VillaRepository;
import com.furama.service.services.VillaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VillaServiceImpl implements VillaService {
    @Autowired
    private VillaRepository villaRepository;
    @Autowired
    private RentTypeRepository rentTypeRepository;
    @Override
    public void save(Villa villa) {
        villaRepository.save(villa);
    }

    @Override
    public void delete(Villa villa) {
        villaRepository.delete(villa);
    }

    @Override
    public Page<Villa> findAll(Pageable pageable) {
        return villaRepository.findAll(pageable);
    }

    @Override
    public Villa findById(String id) {
        return villaRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Villa> findAllByKey(String key, Pageable pageable) {
        return villaRepository.findAllByNameIsContaining(key,pageable);
    }

    @Override
    public List<Villa> findAll() {
        return villaRepository.findAll();
    }
}
