package com.arka.hexagonal.microservice.carritoArka.infraestructure.driven.jpa.entity;

import com.arka.hexagonal.microservice.carritoArka.domain.models.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "pedidos")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "metodo_pago")
    private String metodoPago;

    @Column(name = "referencia")
    private Long reference;

    @Column(name = "fecha_orden")
    private Date date;

    @Column(name = "cantidad_total")
    private BigDecimal amountValue;

    @Column(name = "precio_total", precision = 10,scale = 2, nullable = false)
    private BigDecimal salePrice;

    @Enumerated(value = EnumType.STRING)
    private OrderStatus orderStatus;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "carrito_id", nullable = false)
    @JsonBackReference
    private CarEntity carrito;

    public OrderEntity() {
    }

    public OrderEntity(Long id, String metodoPago, Long reference, Date date, BigDecimal amountValue, BigDecimal salePrice, OrderStatus orderStatus, CarEntity carrito) {
        this.id = id;
        this.metodoPago = metodoPago;
        this.reference = reference;
        this.date = date;
        this.amountValue = amountValue;
        this.salePrice = salePrice;
        this.orderStatus = orderStatus;
        this.carrito = carrito;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Long getReference() {
        return reference;
    }

    public void setReference(Long reference) {
        this.reference = reference;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getAmountValue() {
        return amountValue;
    }

    public void setAmountValue(BigDecimal amountValue) {
        this.amountValue = amountValue;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public CarEntity getCarrito() {
        return carrito;
    }

    public void setCarrito(CarEntity carrito) {
        this.carrito = carrito;
    }
}