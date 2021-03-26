package com.furama.repository.employee;


import com.furama.entity.employee.User;
import com.furama.entity.employee.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole,Integer> {
    List<UserRole> findAllByUser(User user);
}
