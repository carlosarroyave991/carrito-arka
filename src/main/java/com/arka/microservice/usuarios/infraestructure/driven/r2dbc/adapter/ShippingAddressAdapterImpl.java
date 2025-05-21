package com.arka.microservice.usuarios.infraestructure.driven.r2dbc.adapter;

import com.arka.microservice.usuarios.domain.models.ShippingAddressModel;
import com.arka.microservice.usuarios.domain.ports.out.ShippingAddressPersistencePort;
import com.arka.microservice.usuarios.infraestructure.driven.r2dbc.entity.ShippingAddressEntity;
import com.arka.microservice.usuarios.infraestructure.driven.r2dbc.mapper.IShippingAddressEntityMapper;
import com.arka.microservice.usuarios.infraestructure.driven.r2dbc.repository.IShippingAddressRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * El adaptador se encargara de conectar ambas capas, pasando la informacion de la entidad
 * al modelo de dominio.
 */
@Slf4j
@Service
@Primary
@RequiredArgsConstructor
public class ShippingAddressAdapterImpl implements ShippingAddressPersistencePort {
    private final IShippingAddressRepository repository;
    private final IShippingAddressEntityMapper mapper;

    /**
     * Funcion que consulta las direcciones por usuario
     * @param userId identificador del objeto a buscar
     * @return retorna un objeto mapeado para dominio
     */
    @Override
    public Flux<ShippingAddressModel> findByUserId(Long userId) {
        return repository.findByUserId(userId)
                .map(mapper::toModel);
    }

    /**
     * Funcion que guarda un objeto
     * @param model objeto a guardar
     * @return retorna un objeto mapeado para el dominio
     */
    @Override
    public Mono<ShippingAddressModel> save(ShippingAddressModel model) {
        ShippingAddressEntity entity = mapper.toEntity(model);
        return repository.save(entity)
                .map(mapper::toModel);
    }

}
