package com.arka.microservice.usuarios.domain.service.user;

import org.springframework.stereotype.Component;

import static com.arka.microservice.usuarios.domain.config.Const.PATTERN_PHONE;

@Component
public class PhoneValidationService {
    // El patrón definido requiere: entre 6 a 10 numeros
    public boolean isValidEmail(String phone) {
        return phone != null && PATTERN_PHONE.matcher(phone).matches();
    }
}
