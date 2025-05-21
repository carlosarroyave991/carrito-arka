package com.arka.microservice.usuarios.infraestructure.driven.r2dbc.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "shipping_address")
public class ShippingAddressEntity {
    @Id
    private Long id;

    @Column("user_id")
    private Long userId;

    @Column("address_id")
    private Long addressId;

    public ShippingAddressEntity() {
    }

    public ShippingAddressEntity(Long id, Long addressId, Long userId) {
        this.id = id;
        this.addressId = addressId;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
