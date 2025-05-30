package com.blogapp.blogapp.exceptions;


import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.blogapp.blogapp.payloads.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundException(ResourceNotFoundException ex){
        ApiResponse apiResponse = new ApiResponse(null, false, ex);
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }
}
