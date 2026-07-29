package com.oluwaseyi.employeeapi.validation.validator;

import com.oluwaseyi.employeeapi.validation.annotation.ValidDepartment;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Set;

public class ValidDepartmentValidator
        implements ConstraintValidator<ValidDepartment, String> {

    private static final Set<String> ALLOWED_DEPARTMENTS =
            Set.of(
                    "IT",
                    "HR",
                    "Finance",
                    "Marketing"
            );

    @Override
    public boolean isValid(String department,
                           ConstraintValidatorContext context) {

        if (department == null) {
            return true;
        }

        return ALLOWED_DEPARTMENTS.contains(department);
    }
}
