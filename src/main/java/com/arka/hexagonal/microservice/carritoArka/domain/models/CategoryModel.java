package com.arka.hexagonal.microservice.carritoArka.domain.models;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Entidad category creada para el dominio.
 * La idea es que sea inmutable para garantizar consistencia.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryModel {
    @NotNull
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private String image;

    @NotNull
    private Date activeSince;
}
