package com.example.demo.repository;

import com.example.demo.entity.User;
import com.example.demo.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole,Integer> {
    List<UserRole> findAllByUser(User user);
}
