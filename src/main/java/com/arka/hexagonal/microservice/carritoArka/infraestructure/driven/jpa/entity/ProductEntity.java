package com.arka.hexagonal.microservice.carritoArka.infraestructure.driven.jpa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "productos")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_producto")
    private String name;

    @Column(name = "marca")
    private String stamp;

    @Column(name = "precio", precision = 10, scale = 2, nullable = false)
    private BigDecimal price;

    @Column()
    private Integer stock;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<ProductCarEntity> carritos;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    @JsonBackReference
    private CategoryEntity categoria;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "abastecimiento",
            joinColumns = @JoinColumn(name = "producto_id"),
            inverseJoinColumns = @JoinColumn(name = "abastecimiento_id")
    )
    private List<SupplyEntity> abastecimientos;

    public ProductEntity() {
    }

    public ProductEntity(Long id, List<SupplyEntity> abastecimientos, CategoryEntity categoria, List<ProductCarEntity> carritos, Integer stock, BigDecimal price, String stamp, String name) {
        this.id = id;
        this.abastecimientos = abastecimientos;
        this.categoria = categoria;
        this.carritos = carritos;
        this.stock = stock;
        this.price = price;
        this.stamp = stamp;
        this.name = name;
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

    public String getStamp() {
        return stamp;
    }

    public void setStamp(String stamp) {
        this.stamp = stamp;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public CategoryEntity getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoryEntity categoria) {
        this.categoria = categoria;
    }

    public List<ProductCarEntity> getCarritos() {
        return carritos;
    }

    public void setCarritos(List<ProductCarEntity> carritos) {
        this.carritos = carritos;
    }

    public List<SupplyEntity> getAbastecimientos() {
        return abastecimientos;
    }

    public void setAbastecimientos(List<SupplyEntity> abastecimientos) {
        this.abastecimientos = abastecimientos;
    }
}
