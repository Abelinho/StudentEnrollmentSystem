package com.abel.StudentEnrollmentSystem.StudentEnrollmentSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abel.StudentEnrollmentSystem.StudentEnrollmentSystem.Entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
   
}
