package com.arka.microservice.usuarios.domain.service.user;

import org.springframework.stereotype.Component;

import static com.arka.microservice.usuarios.domain.config.Const.PATTERN_PASSWORD;

@Component
public class PasswordValidationService {
    // La expresión regular a continuación verifica que la contraseña:
    // - Tenga al menos 8 caracteres.
    // - Contenga al menos una letra minúscula.
    // - Contenga al menos una letra mayúscula.
    // - Contenga al menos un dígito.

    public boolean isValidPassword(String password) {
        return password != null && PATTERN_PASSWORD.matcher(password).matches();
    }
}
