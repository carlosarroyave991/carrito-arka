package com.arka.hexagonal.microservice.carritoArka.infraestructure.driver.rest.dto.user.req;

import com.arka.hexagonal.microservice.carritoArka.domain.models.enums.UserType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.*;

public class UserRequestDto {
    @Null(message = "El id debe ser nulo para una operación de creación")
    private Long id;// Opcional para 'save', necesario para 'update'

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

    public UserRequestDto(Long id, String email, String name, UserType userType, String phone, String dni) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.userType = userType;
        this.phone = phone;
        this.dni = dni;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
