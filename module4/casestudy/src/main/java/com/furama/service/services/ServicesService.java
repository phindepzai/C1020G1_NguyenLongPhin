package com.furama.service.services;

import com.furama.entity.services.RentType;
import com.furama.entity.services.ServicesType;

import java.util.List;

public interface ServicesService {
    List<RentType> findAllRentType();

    List<ServicesType> findAllServicesType();

    void delete(String id);
}
