package com.example.crud.service;

import com.example.crud.model.Department;
import com.example.crud.model.Employee;
import com.example.crud.repository.DepartmentRepository;
import com.example.crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee addEmployee(Employee employee) {
        Department dept = departmentRepository.findById(employee.getDepartment().getId()).orElse(null);
        if (null == dept) {
            dept = new Department();
        }
        dept.setDeptName(employee.getDepartment().getDeptName());
        employee.setDepartment(dept);
        return employeeRepository.save(employee);
    }

    public Employee editEmployees(Employee entity) {
        return employeeRepository.save(entity);
    }

    public void deleteEmployees(Integer id) {
        employeeRepository.deleteById(id);
    }
}
