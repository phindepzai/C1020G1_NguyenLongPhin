package com.furama.repository.employee;

import com.furama.entity.customer.Customer;
import com.furama.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    @Query(value = "select * from employee e where e.id like %:key% or  e.name like %:key% or e.phone like %:key% or e.email like %:key%",nativeQuery = true)
    Page<Employee> findAllContaining(@Param("key") String key, Pageable pageable);
    Page<Employee> findAll(Pageable pageable);
    Employee findByEmail(String email);
}
