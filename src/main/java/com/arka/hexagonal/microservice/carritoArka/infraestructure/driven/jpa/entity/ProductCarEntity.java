package com.arka.hexagonal.microservice.carritoArka.infraestructure.driven.jpa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "carrito_producto")
public class ProductCarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cantidad")
    private Integer amount;

    @ManyToOne
    @JoinColumn(name = "carrito_id", nullable = false)
    @JsonBackReference
    private CarEntity carrito;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    @JsonBackReference
    private ProductEntity producto;

    public ProductCarEntity() {
    }

    public ProductCarEntity(Long id, CarEntity carrito, Integer amount, ProductEntity producto) {
        this.id = id;
        this.carrito = carrito;
        this.amount = amount;
        this.producto = producto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public CarEntity getCarrito() {
        return carrito;
    }

    public void setCarrito(CarEntity carrito) {
        this.carrito = carrito;
    }

    public ProductEntity getProducto() {
        return producto;
    }

    public void setProducto(ProductEntity producto) {
        this.producto = producto;
    }
}
