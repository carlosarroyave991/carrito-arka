package com.arka.hexagonal.microservice.carritoArka.configuration.helpers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHelper {
    public static <T> ResponseEntity<T> sucessResponse(T body){
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    public static <T> ResponseEntity<T> badRequestResponse(T body){
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}
