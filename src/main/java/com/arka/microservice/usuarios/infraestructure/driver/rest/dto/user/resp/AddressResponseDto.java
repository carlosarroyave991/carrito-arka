package com.arka.microservice.usuarios.infraestructure.driver.rest.dto.user.resp;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

public class AddressResponseDto {
    //El id debe ser nulo para una operación de creación
    @Null(message = "The id must be null for a create operation")
    private Long id;// Opcional para 'save', necesario para 'update'
    private String address;
    private String city;
    private String country;
    private String street;
    private String zipCode;

    public AddressResponseDto() {
    }

    public AddressResponseDto(Long id, String zipCode, String street, String country, String city, String address) {
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
