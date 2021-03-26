package com.furama.repository.employee;

import com.furama.entity.employee.EducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationDegreeRepository extends JpaRepository<EducationDegree,Integer> {
}