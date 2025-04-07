package com.arka.hexagonal.microservice.carritoArka.infraestructure.driven.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "carritos")
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "fecha_creacion")
    private Date createdDate;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UserEntity usuario;

    @OneToMany(mappedBy = "carrito", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<ProductCarEntity> carritoProductos;

    @JsonIgnore
    @OneToOne(mappedBy = "carrito")
    private OrderEntity pedido;

    public CarEntity() {
    }

    public CarEntity(Long id, Date createdDate, UserEntity usuario, List<ProductCarEntity> carritoProductos, OrderEntity pedido) {
        this.id = id;
        this.createdDate = createdDate;
        this.usuario = usuario;
        this.carritoProductos = carritoProductos;
        this.pedido = pedido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public UserEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UserEntity usuario) {
        this.usuario = usuario;
    }

    public List<ProductCarEntity> getCarritoProductos() {
        return carritoProductos;
    }

    public void setCarritoProductos(List<ProductCarEntity> carritoProductos) {
        this.carritoProductos = carritoProductos;
    }

    public OrderEntity getPedido() {
        return pedido;
    }

    public void setPedido(OrderEntity pedido) {
        this.pedido = pedido;
    }
}
