package com.example.spring.web.exceptions;

public class DuplicateOrderEmailException extends RuntimeException {
    public DuplicateOrderEmailException(String message) {
        super(message);
    }

}
