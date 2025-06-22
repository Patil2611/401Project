package com.blogapp.blogapp.exceptions;


import java.util.HashMap;
import java.util.Map;

import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.blogapp.blogapp.payloads.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundException(ResourceNotFoundException ex){
        ApiResponse apiResponse = new ApiResponse(ex.getMessage(), false, "Data not found");
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public String noResourceFoundException(NoResourceFoundException ex){
        return "Url not found";
    }

    @ExceptionHandler(PropertyReferenceException.class)
    public String propertyReferenceException(PropertyReferenceException ex){
        return "Property not found";
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> validationException(MethodArgumentNotValidException ex){
        Map<String, String> m = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error)->{
            String fieldName = ((FieldError)error).getField();
            String message = error.getDefaultMessage();

            m.put(fieldName, message);
        });

        return new ResponseEntity<>(new ApiResponse("Validation failed", false, m), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<ApiResponse> invalidTokenException(InvalidTokenException ex){
        ApiResponse apiResponse = new ApiResponse(ex.getMessage(), false, "Invalid token");
        return new ResponseEntity<>(apiResponse, HttpStatus.UNAUTHORIZED);
    }
}
