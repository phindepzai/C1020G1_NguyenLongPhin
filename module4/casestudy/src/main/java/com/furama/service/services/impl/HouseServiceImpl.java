package com.furama.service.services.impl;

import com.furama.entity.services.House;
import com.furama.repository.services.HouseRepository;
import com.furama.service.services.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    private HouseRepository houseRepository;
    @Override
    public void save(House house) {
        houseRepository.save(house);
    }

    @Override
    public void delete(String id) {
        houseRepository.delete(findById(id));
    }

    @Override
    public Page<House> findAll(Pageable pageable) {
        return houseRepository.findAll(pageable);
    }

    @Override
    public House findById(String id) {
        return houseRepository.findById(id).orElse(null);
    }

    @Override
    public Page<House> findAllByKey(String key, Pageable pageable) {
        return houseRepository.findAllByNameIsContaining(key,pageable);
    }

    @Override
    public List<House> findAll() {
        return houseRepository.findAll();
    }
}
