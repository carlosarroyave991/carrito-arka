package com.arka.microservice.usuarios.domain.ports.in;

import com.arka.microservice.usuarios.domain.models.AuthModel;
import com.arka.microservice.usuarios.domain.models.UserModel;
import reactor.core.publisher.Mono;

/**
 * Se definen las operaciones REST que pueden utilizar para interactuar
 * con el nucreo del sistema.
 */
public interface IAuthPortUseCase {
    Mono<AuthModel> authenticateUser(UserModel user);
}
