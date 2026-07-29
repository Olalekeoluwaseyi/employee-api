package com.oluwaseyi.employeeapi.model;


import com.oluwaseyi.employeeapi.validation.annotation.ValidDepartment;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Department is required")
    @ValidDepartment
    private String department;

    @Positive(message = "Salary must be greater than zero")
    private Double salary;

    public Employee() {}

    public Employee(String name, String department,  Double salary) {

        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
            return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getDepartment(){
        return department;
    }
    public void setDepartment (String department){
        this.department = department;
    }

    public Double getSalary() {return salary;};
    public void setSalary(Double salary) {this.salary = salary;};
}
