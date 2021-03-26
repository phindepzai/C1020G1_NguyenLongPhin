package com.binzet.customer_ver2.service;

import com.binzet.customer_ver2.entity.Province;

public interface ProvinceService {
    Iterable<Province> findAll();

    Province findById(Long id);

    void save(Province province);

    void remove(Long id);
}
