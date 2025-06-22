package com.blogapp.blogapp.exceptions;

public class InvalidTokenException extends RuntimeException{
    public InvalidTokenException(String ex){
        super(ex);
    }
}
