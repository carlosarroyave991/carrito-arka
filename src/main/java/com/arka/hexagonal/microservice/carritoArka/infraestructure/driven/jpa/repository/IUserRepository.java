package com.arka.hexagonal.microservice.carritoArka.infraestructure.driven.jpa.repository;

import com.arka.hexagonal.microservice.carritoArka.infraestructure.driven.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Se ocupa de las interacciones con la base de datos u otra fuente de datos,
 * generalmente utilizando entidades JPA u otro mapeo relacionado con la base de datos.
 * Puede no necesitar todos los métodos definidos en el puerto.
 */
public interface IUserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findById(Long id);
    Optional<UserEntity> findByDni(String dni);

    @Query("SELECT u FROM UserEntity u WHERE u.name LIKE CONCAT('%', :name, '%')")
    Optional<List<UserEntity>> findByName(@Param("name") String name);

    Optional<List<UserEntity>> findByNameContaining(String name);

}
