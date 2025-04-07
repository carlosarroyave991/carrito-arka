package com.arka.hexagonal.microservice.carritoArka.infraestructure.driven.jpa.entity;

import com.arka.hexagonal.microservice.carritoArka.domain.models.enums.UserType;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "usuarios")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombres")
    private String name;

    @Column(name = "tipo_usuario")
    @Enumerated(value = EnumType.STRING)
    private UserType userType;

    @Column(name = "correo")
    private String email;

    @Column(name = "telefono")
    private String phone;

    @Column()
    private String dni;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CarEntity> carritos;

    public UserEntity() {
    }

    public UserEntity(Long id, UserType userType, String name, String email, String phone, String dni, List<CarEntity> carritos) {
        this.id = id;
        this.userType = userType;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.dni = dni;
        this.carritos = carritos;
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

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public List<CarEntity> getCarritos() {
        return carritos;
    }

    public void setCarritos(List<CarEntity> carritos) {
        this.carritos = carritos;
    }
}
