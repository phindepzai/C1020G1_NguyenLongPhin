package com.furama.repository.customer;

import com.furama.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,String> {
    @Query(value = "select * from customer c where c.id like %:key% or  c.name like %:key% or c.phone like %:key% or c.email like %:key%",nativeQuery = true)
    Page<Customer> findByContaining(@Param("key") String key, Pageable pageable);
    Page<Customer> findAll(Pageable pageable);
    List<Customer> findAll();
}
