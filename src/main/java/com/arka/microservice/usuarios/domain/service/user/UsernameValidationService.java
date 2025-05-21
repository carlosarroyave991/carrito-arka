package com.arka.microservice.usuarios.domain.service.user;

import org.springframework.stereotype.Component;

import static com.arka.microservice.usuarios.domain.config.Const.PATTERN_USERNAME;

@Component
public class UsernameValidationService {
    // El patrón requiere:
    // - Que el username inicie con una letra (a-z o A-Z).
    // - Que tenga entre 3 y 20 caracteres en total.
    // - Que los caracteres siguientes puedan ser letras, números, guión bajo o guión.

    public boolean isValidUsername(String username) {
        return username != null && PATTERN_USERNAME.matcher(username).matches();
    }
}
