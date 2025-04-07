package com.arka.hexagonal.microservice.carritoArka.domain.ports.in;

import com.arka.hexagonal.microservice.carritoArka.domain.models.UserModel;
import com.arka.hexagonal.microservice.carritoArka.domain.models.enums.UserType;

import java.util.List;
import java.util.Optional;

/**
 * Define las operaciones REST que pueden utilizar para interactuar
 * con el nucreo del sistema.
 */
public interface IUserPortUseCase {
    Optional<UserModel> getUserById(Long id);
    //boolean userTypeIsValid(UserType userType);
    Optional<List<UserModel>>getUsersByName(String name);
    List<UserModel> getAllUsers();
    UserModel createUser(UserModel user);
    UserModel updateUser(UserModel user, Long id);
    void deleteUser(Long id);
}
