package com.arka.hexagonal.microservice.carritoArka.domain.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * Entidad carrito creada para el dominio.
 * La idea es que sea inmutable para garantizar consistencia.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarModel {
    Long id;

    Date createdDate;

    UserModel cliente;

    List<ProductCarModel> carritoProductos;
}
