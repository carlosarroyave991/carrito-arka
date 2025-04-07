package com.arka.hexagonal.microservice.carritoArka.domain.models;

import com.arka.hexagonal.microservice.carritoArka.domain.models.enums.OrderStatus;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;


/**
 * Entidad pedido creada para el dominio.
 * La idea es que sea inmutable para garantizar consistencia.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderModel {
    @NotNull
    private Long id;

    @NotNull
    private String metodoPago;

    @NotNull
    private Long reference;

    @NotNull
    private Date date;

    @NotNull
    private BigDecimal amountValue;

    @NotNull
    private BigDecimal salePrice;

    @NotNull
    private OrderStatus orderStatus;

    private CarModel carrito;
}
