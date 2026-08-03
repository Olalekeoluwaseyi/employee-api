package com.oluwaseyi.employeeapi.mapper;

import com.oluwaseyi.employeeapi.dto.request.CreateEmployeeRequest;
import com.oluwaseyi.employeeapi.dto.response.EmployeeResponse;
import com.oluwaseyi.employeeapi.model.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapperMapStruct {

    Employee toEmployee(CreateEmployeeRequest request);

    EmployeeResponse toEmployeeResponse(Employee employee);
}
