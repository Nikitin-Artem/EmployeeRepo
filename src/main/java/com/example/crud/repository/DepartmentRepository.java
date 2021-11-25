package com.example.crud.repository;

import com.example.crud.model.Department;
import com.example.crud.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
