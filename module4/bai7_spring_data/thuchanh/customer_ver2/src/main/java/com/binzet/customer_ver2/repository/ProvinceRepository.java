package com.binzet.customer_ver2.repository;

import com.binzet.customer_ver2.entity.Province;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepository extends PagingAndSortingRepository<Province, Long> {
}
