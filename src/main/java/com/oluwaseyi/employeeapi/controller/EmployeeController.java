package com.oluwaseyi.employeeapi.controller;

import com.oluwaseyi.employeeapi.model.Employee;
import com.oluwaseyi.employeeapi.service.EmployeeService;


import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController (EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeesById(@PathVariable int id){

        return employeeService.getEmployeeById(id);
    }

    @PostMapping()
    public Employee addEmployee(@Valid @RequestBody Employee employee){
        return employeeService.addEmployee(employee) ;
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable int id, @Valid @RequestBody Employee updatedEmployee){
        return employeeService.updateEmployee(id, updatedEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id){

        employeeService.deleteEmployee(id);

        return ResponseEntity.ok().body("Employee deleted successfully");
    }

}



