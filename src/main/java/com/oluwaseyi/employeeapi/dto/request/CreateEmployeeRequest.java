package com.oluwaseyi.employeeapi.dto.request;

import com.oluwaseyi.employeeapi.validation.annotation.ValidDepartment;
import jakarta.validation.constraints.NotBlank;

public class CreateEmployeeRequest {

    private String name;
    @NotBlank(message = "Department is required")
    @ValidDepartment
    private String department;
    private Double salary;
}
