package com.furama.repository.services;

import com.furama.entity.services.ServicesType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicesTypeRepository extends JpaRepository<ServicesType,Integer> {
}
