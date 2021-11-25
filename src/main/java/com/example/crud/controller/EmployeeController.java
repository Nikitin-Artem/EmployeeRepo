package com.example.crud.controller;

import com.example.crud.model.Employee;
import com.example.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/get-employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping("/employee")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        Employee emp = employeeService.addEmployee(employee);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @PutMapping("/employee")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee emp = employeeService.editEmployees(employee);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @DeleteMapping("/employee")
    public ResponseEntity<String> deleteEmployee(@RequestParam(name = "employeeId") Integer employeeId) {
        employeeService.deleteEmployees(employeeId);
        return new ResponseEntity<>("Employee with ID :" + employeeId + " deleted successfully", HttpStatus.OK);
    }
}
