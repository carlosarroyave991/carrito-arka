package com.arka.hexagonal.microservice.carritoArka.configuration.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandler {

    public static void throwError(String message) {
        throw new IllegalArgumentException(message);
    }

    public static void throwError(RuntimeException exception, String message) {
        exception = new RuntimeException(message);
        throw exception;
    }
}
