package com.arka.microservice.usuarios.domain.service.address;

import org.springframework.stereotype.Component;

import static com.arka.microservice.usuarios.domain.config.Const.PATTERN_ZIPCODE;

@Component
public class ZipCodeValidationService {
    // El patrón definido requiere: 5 numeros obligatorios
    public boolean isValidZipCode(String zipCode){
        return zipCode != null && PATTERN_ZIPCODE.matcher(zipCode).matches();
    }
}
