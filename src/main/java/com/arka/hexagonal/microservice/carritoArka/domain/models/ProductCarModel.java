package com.arka.hexagonal.microservice.carritoArka.domain.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidad carrito producto creada para el dominio.
 * La idea es que sea inmutable para garantizar consistencia.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductCarModel {
    Long id;

    Integer amount;

    @JsonIgnore
    CarModel carrito;

    ProductModel producto;
}
