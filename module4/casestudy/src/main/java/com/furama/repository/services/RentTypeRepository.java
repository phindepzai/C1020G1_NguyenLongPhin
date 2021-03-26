package com.furama.repository.services;

import com.furama.entity.services.RentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentTypeRepository extends JpaRepository<RentType,Integer> {
}
