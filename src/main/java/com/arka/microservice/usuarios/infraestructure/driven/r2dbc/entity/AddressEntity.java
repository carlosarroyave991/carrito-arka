package com.arka.microservice.usuarios.infraestructure.driven.r2dbc.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "address")
public class AddressEntity {
    @Id
    private Long id;


    private String address;
    private String city;
    private String country;
    private String street;

    @Column("zip_code")
    private String zipCode;

    /*@MappedCollection(idColumn = "address_id", keyColumn = "id")
    private List<ShippingAddressEntity> shippingAddressEntityList;*/

    public AddressEntity() {
    }

    public AddressEntity(Long id, String zipCode, String street, String country, String city, String address) {
        this.id = id;
        this.zipCode = zipCode;
        this.street = street;
        this.country = country;
        this.city = city;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

}
