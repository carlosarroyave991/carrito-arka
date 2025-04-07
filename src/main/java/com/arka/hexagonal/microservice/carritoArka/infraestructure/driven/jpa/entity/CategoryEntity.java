package com.arka.hexagonal.microservice.carritoArka.infraestructure.driven.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "categorias")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "descipcion")
    private String description;

    @Column(name = "imagen")
    private String image;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date activeSince;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<ProductEntity> productos;

    public CategoryEntity() {
    }

    public CategoryEntity(Long id, String name, String description, String image, Date activeSince, List<ProductEntity> productos) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.activeSince = activeSince;
        this.productos = productos;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getActiveSince() {
        return activeSince;
    }

    public void setActiveSince(Date activeSince) {
        this.activeSince = activeSince;
    }

    public List<ProductEntity> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductEntity> productos) {
        this.productos = productos;
    }
}
