package com.arka.microservice.usuarios.infraestructure.driven.r2dbc.repository;

import com.arka.microservice.usuarios.infraestructure.driven.r2dbc.entity.ShippingAddressEntity;
import com.arka.microservice.usuarios.infraestructure.driven.r2dbc.entity.UserEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Se ocupa de las interacciones con la base de datos u otra fuente de datos,
 * generalmente utilizando entidades JPA u otro mapeo relacionado con la base de datos.
 * Puede no necesitar todos los métodos definidos en el puerto.
 */
public interface IShippingAddressRepository extends ReactiveCrudRepository<ShippingAddressEntity, Long> {
    Flux<ShippingAddressEntity> findByUserId(Long userId);

    Mono<ShippingAddressEntity> findByUserIdAndAddressId(Long userId, Long addressId);
}
