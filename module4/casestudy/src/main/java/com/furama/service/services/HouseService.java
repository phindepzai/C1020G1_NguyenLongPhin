package com.furama.service.services;

import com.furama.entity.services.House;
import com.furama.entity.services.Villa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HouseService {
    void save(House house);
    void delete(String id);
    Page<House> findAll(Pageable pageable);
    House findById(String id);
    Page<House> findAllByKey(String key, Pageable pageable);
    List<House> findAll();
}
