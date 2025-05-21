package com.arka.microservice.usuarios.domain.ports.in;

import com.arka.microservice.usuarios.domain.models.ShippingAddressModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Se definen las operaciones REST que pueden utilizar para interactuar
 * con el nucreo del sistema.
 */
public interface IShippingAddressPortUseCase {
    Mono<ShippingAddressModel> save(ShippingAddressModel model);
}
