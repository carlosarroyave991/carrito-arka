package com.arka.microservice.usuarios.domain.ports.out;

import com.arka.microservice.usuarios.domain.models.AddressModel;
import com.arka.microservice.usuarios.domain.models.UserModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Se encarga de definir las dependencias externas que el nucleo necesita.
 */
public interface AddressPersistencePort {
    Mono<AddressModel> findById(Long id);
    Flux<AddressModel> findAll();
    Mono<AddressModel> save(AddressModel model);
    Mono<AddressModel> update(AddressModel model);
    Mono<Void> deleteById(Long id);
}
