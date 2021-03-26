package com.binzet.blog.repository;

import com.binzet.blog.entity.AppUser;
import com.binzet.blog.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
    List<UserRole> findByAppUser(AppUser appUser);
}
