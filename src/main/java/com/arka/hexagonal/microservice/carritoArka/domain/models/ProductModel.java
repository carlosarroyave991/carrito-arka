package com.arka.hexagonal.microservice.carritoArka.domain.models;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductModel {

    @NotNull
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String stamp;

    @NotNull
    private BigDecimal price;

    @NotNull
    private Integer stock;
}
