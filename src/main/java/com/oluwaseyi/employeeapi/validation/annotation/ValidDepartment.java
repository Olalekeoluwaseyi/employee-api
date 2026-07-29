package com.oluwaseyi.employeeapi.validation.annotation;

import com.oluwaseyi.employeeapi.validation.validator.ValidDepartmentValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidDepartmentValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidDepartment {

    String message() default "Invalid department";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
