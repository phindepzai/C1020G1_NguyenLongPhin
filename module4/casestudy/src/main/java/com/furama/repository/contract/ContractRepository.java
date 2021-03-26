package com.furama.repository.contract;

import com.furama.entity.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer> {
    Page<Contract> findAllByEndDateAfter(String yes, Pageable pageable);

    @Query(value = "select * from contract c join customer m on c.customer_id = m.id join employee e on c.employee_id = e.id join services s on c.services_id = s.id where m.name like %:key% or  s.name like %:key% or s.name like %:key%", nativeQuery = true)
    Page<Contract> findAllByContaining(@Param("key") String key, Pageable pageable);

    @Query(value = "select * from contract c join customer m on c.customer_id = m.id where not datediff(c.end_date,now()) < 0 and concat(m.name,m.email,m.phone,m.id) like %:key%", nativeQuery = true)
    Page<Contract> findAllByEndDateAfterContaining(@Param("key") String key, Pageable pageable);
}
