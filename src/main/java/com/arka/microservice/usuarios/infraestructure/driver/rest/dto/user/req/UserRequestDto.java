package com.arka.microservice.usuarios.infraestructure.driver.rest.dto.user.req;

import com.arka.microservice.usuarios.domain.models.enums.UserType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

public class UserRequestDto {
    //El id debe ser nulo para una operación de creación
    @Null(message = "The id must be null for a create operation")
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

    @NotNull
    private String username;

    @NotNull
    private String password;

    public UserRequestDto(Long id, String password, String username, String dni, String phone, String email, UserType userType, String name) {
        this.id = id;
        this.password = password;
        this.username = username;
        this.dni = dni;
        this.phone = phone;
        this.email = email;
        this.userType = userType;
        this.name = name;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
