package com.arka.microservice.usuarios.infraestructure.driver.rest.dto.user.req;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import org.springframework.data.relational.core.mapping.Column;

public class AddressRequestDto {

    //El id debe ser nulo para una operación de creación
    @Null(message = "The id must be null for a create operation")
    private Long id;// Opcional para 'save', necesario para 'update'

    @NotNull
    private String address;
    @NotNull
    private String city;
    @NotNull
    private String country;
    @NotNull
    private String street;
    @NotNull
    private String zipCode;

    public AddressRequestDto(Long id, String zipCode, String street, String country, String city, String address) {
        this.id = id;
        this.zipCode = zipCode;
        this.street = street;
        this.country = country;
        this.city = city;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
