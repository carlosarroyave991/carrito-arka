package com.arka.microservice.usuarios.infraestructure.driver.rest.dto.user.resp;

import com.arka.microservice.usuarios.domain.models.enums.UserType;

public class UserResponseDto {

    private Long id;
    private String name;
    private UserType userType;
    private String email;
    private String phone;
    private String dni;

    public UserResponseDto(Long id, String dni, String phone, String email, UserType userType, String name) {
        this.id = id;
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
