package com.oluwaseyi.employeeapi.service;

import com.oluwaseyi.employeeapi.exception.EmployeeNotFoundException;
import com.oluwaseyi.employeeapi.model.Employee;
import com.oluwaseyi.employeeapi.repository.EmployeeRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {

        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(int id){

        List<Employee> employees = getEmployees();
        for(Employee employee : employees){
            if(employee.getId() == id){
                return employee;
            }
        }
        return null;
    }


    @Override
    public Employee addEmployee(Employee employee){

        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Integer id, Employee updatedEmployee) {

        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));

        existingEmployee.setName(updatedEmployee.getName());
        existingEmployee.setDepartment(updatedEmployee.getDepartment());
        existingEmployee.setSalary(updatedEmployee.getSalary());
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public void deleteEmployee(int id){
        Employee existingEmployee =  employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
        employeeRepository.delete(existingEmployee);
    }
}
