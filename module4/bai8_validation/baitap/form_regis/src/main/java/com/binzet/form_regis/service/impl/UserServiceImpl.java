package com.binzet.form_regis.service.impl;

import com.binzet.form_regis.entity.User;
import com.binzet.form_regis.repository.UserRepository;
import com.binzet.form_regis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void delete(String email) {
        userRepository.deleteByEmail(email);
    }
}
