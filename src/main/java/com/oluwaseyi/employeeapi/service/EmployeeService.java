package com.oluwaseyi.employeeapi.service;

import com.oluwaseyi.employeeapi.model.Employee;

import java.util.List;

import java.util.List;


public interface EmployeeService {

    List<Employee> getEmployees();

    Employee getEmployeeById(int id);

    Employee addEmployee(Employee employee);

    Employee updateEmployee(Integer id, Employee employee);

    void deleteEmployee(int id);
}
