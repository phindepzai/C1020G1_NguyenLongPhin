package com.furama.service.services.impl;

import com.furama.entity.services.RentType;
import com.furama.entity.services.Services;
import com.furama.entity.services.ServicesType;
import com.furama.repository.services.RentTypeRepository;
import com.furama.repository.services.ServicesRepository;
import com.furama.repository.services.ServicesTypeRepository;
import com.furama.service.services.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesServiceImpl implements ServicesService {
    @Autowired
    private ServicesRepository servicesRepository;
    @Autowired
    private RentTypeRepository rentTypeRepository;
    @Autowired
    private ServicesTypeRepository servicesTypeRepository;
    @Override
    public List<RentType> findAllRentType() {
        return rentTypeRepository.findAll();
    }

    @Override
    public List<ServicesType> findAllServicesType() {
        return servicesTypeRepository.findAll();
    }

    @Override
    public void delete(String id){
        servicesRepository.deleteById(id);
    }
}
