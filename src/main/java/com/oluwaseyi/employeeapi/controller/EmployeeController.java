package com.oluwaseyi.employeeapi.controller;

import com.oluwaseyi.employeeapi.dto.request.CreateEmployeeRequest;
import com.oluwaseyi.employeeapi.dto.response.EmployeeResponse;
import com.oluwaseyi.employeeapi.model.Employee;
import com.oluwaseyi.employeeapi.service.EmployeeService;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<EmployeeResponse> addEmployee(@Valid @RequestBody CreateEmployeeRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.addEmployee(request)) ;
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



