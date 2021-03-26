package com.furama.repository.services;

import com.furama.entity.services.House;
import com.furama.entity.services.Villa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepository extends JpaRepository<House,String> {
    Page<House> findAllByNameIsContaining(String name, Pageable pageable);
}
