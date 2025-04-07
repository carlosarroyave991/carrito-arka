package com.arka.hexagonal.microservice.carritoArka.infraestructure.driven.jpa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import javax.annotation.processing.Generated;
import java.util.Date;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "abastecimientos")
public class SupplyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cantidad")
    private Integer quantity;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "fecha_abastecimiento")
    private Date operationDated;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    @JsonBackReference
    private ProductEntity producto;

    @ManyToOne
    @JoinColumn(name = "almacen_id", nullable = false)
    @JsonBackReference
    private StorageEntity almacen;

    public SupplyEntity() {
    }

    public SupplyEntity(Long id, Integer quantity, Date operationDated, ProductEntity producto, StorageEntity almacen) {
        this.id = id;
        this.quantity = quantity;
        this.operationDated = operationDated;
        this.producto = producto;
        this.almacen = almacen;
    }

    public Date getOperationDated() {
        return operationDated;
    }

    public void setOperationDated(Date operationDated) {
        this.operationDated = operationDated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StorageEntity getAlmacen() {
        return almacen;
    }

    public void setAlmacen(StorageEntity almacen) {
        this.almacen = almacen;
    }

    public ProductEntity getProducto() {
        return producto;
    }

    public void setProducto(ProductEntity producto) {
        this.producto = producto;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
