package com.binzet.form_regis.service;

import com.binzet.form_regis.entity.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public interface UserService {
    void save(User user);
    Page<User> findAll(Pageable pageable);
    User findByEmail(String email);
    void delete(String email);
}
