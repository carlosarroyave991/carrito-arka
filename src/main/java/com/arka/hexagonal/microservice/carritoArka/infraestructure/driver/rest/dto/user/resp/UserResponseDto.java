package com.arka.hexagonal.microservice.carritoArka.infraestructure.driver.rest.dto.user.resp;

import com.arka.hexagonal.microservice.carritoArka.domain.models.enums.UserType;

public class UserResponseDto {
    private String name;

    private UserType userType;

    private String email;

    private String phone;

    private String dni;

    public UserResponseDto(String name, String email, UserType userType, String dni, String phone) {
        this.name = name;
        this.email = email;
        this.userType = userType;
        this.dni = dni;
        this.phone = phone;
    }

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
