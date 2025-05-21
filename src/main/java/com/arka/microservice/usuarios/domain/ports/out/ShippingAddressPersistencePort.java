package com.arka.microservice.usuarios.domain.ports.out;

import com.arka.microservice.usuarios.domain.models.ShippingAddressModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Se encarga de definir las dependencias externas que el nucleo necesita.
 */
public interface ShippingAddressPersistencePort {
    Flux<ShippingAddressModel> findByUserId(Long userId);
    Mono<ShippingAddressModel> save(ShippingAddressModel model);
}
