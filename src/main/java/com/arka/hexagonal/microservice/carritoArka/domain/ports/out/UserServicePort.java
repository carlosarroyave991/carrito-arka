package com.arka.hexagonal.microservice.carritoArka.domain.ports.out;

import com.arka.hexagonal.microservice.carritoArka.domain.models.UserModel;

import java.util.List;
import java.util.Optional;

/**
 * Se encarga de definir las dependencias externas que el nucleo necesita.
 */
public interface UserServicePort {
    Optional<UserModel> findById(Long id);
    Optional<List<UserModel>> findByName(String name);
    Optional<UserModel> findByDni(String dni);
    List<UserModel> findAll();
    UserModel save(UserModel user);
    UserModel update(UserModel user, Long id);
    void deleteById(Long id);
}
