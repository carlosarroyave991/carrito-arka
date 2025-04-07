package com.arka.hexagonal.microservice.carritoArka.domain.models;

import com.arka.hexagonal.microservice.carritoArka.domain.models.enums.UserType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Entidad cliente creada para el dominio.
 * La idea es que sea inmutable para garantizar consistencia.
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserModel {
    @NotNull
    private String name;

    @NotNull
    private UserType userType;

    @NotNull
    private String email;

    @NotNull
    private String phone;

    @NotNull
    private String dni;

    // Opcional: incluir solo si es relevante para el dominio
    /*private List<CarModel> carritos;*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
