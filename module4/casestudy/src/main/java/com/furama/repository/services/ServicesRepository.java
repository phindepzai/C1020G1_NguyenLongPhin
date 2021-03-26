package com.furama.repository.services;

import com.furama.entity.services.Services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicesRepository extends JpaRepository<Services,String> {
    Page<Services> findAllByNameIsContaining(String name, Pageable pageable);
    @Query(value = "delete from services s where s.id = ?1",nativeQuery = true)
    void deleteById(String id);
}
