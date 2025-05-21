package com.arka.microservice.usuarios.domain.models;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * Entidad cliente creada para el dominio.
 * La idea es que sea inmutable para garantizar consistencia.
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShippingAddressModel {
    private Long id;
    private Long addressId;
    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }
}
