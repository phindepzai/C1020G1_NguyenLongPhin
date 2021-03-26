package com.furama.repository.employee;


import com.furama.entity.employee.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
//    @Query(value = "select * from user where username = :username",nativeQuery = true)
    User findByUsername(@Param("username") String username);
}
