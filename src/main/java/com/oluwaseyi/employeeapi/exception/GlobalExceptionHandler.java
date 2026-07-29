package com.oluwaseyi.employeeapi.exception;

import com.oluwaseyi.employeeapi.dto.response.ErrorResponse;
import com.oluwaseyi.employeeapi.dto.response.NotFoundErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidaException(MethodArgumentNotValidException ex){

        Map<String, String> errors = new HashMap<>();
        ErrorResponse errorResponse = new ErrorResponse();
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

        for(FieldError fieldError : fieldErrors){
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        errorResponse.setTimestamp(LocalDateTime.now());
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setErrors(errors);

        return ResponseEntity.badRequest().body(errorResponse);

    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<NotFoundErrorResponse> handleEmployeeNotFound (EmployeeNotFoundException ex){

        NotFoundErrorResponse notFoundErrorResponse = new NotFoundErrorResponse();
        notFoundErrorResponse.setTimestamp(LocalDateTime.now());
        notFoundErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        notFoundErrorResponse.setMessage(ex.getMessage());

        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFoundErrorResponse);
    }

}
