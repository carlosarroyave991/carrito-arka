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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SupplyModel {
    @NotNull
    private Long Id;

    @NotNull
    private Integer quantity;

    @NotNull
    private Date operationDated;
}
