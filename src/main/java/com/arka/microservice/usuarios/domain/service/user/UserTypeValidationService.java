package com.arka.microservice.usuarios.domain.service.user;

import com.arka.microservice.usuarios.domain.models.enums.UserType;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class UserTypeValidationService {
    // Verifica si el tipoUsuario pertenece a los valores definidos en el enum
    public boolean isValidUserType(UserType userType) {
        return Arrays.stream(UserType.values())
                .anyMatch(tipo -> tipo == userType);
    }
}
