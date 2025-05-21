package com.arka.microservice.usuarios.infraestructure.driven.r2dbc.adapter;

import com.arka.microservice.usuarios.domain.models.AddressModel;
import com.arka.microservice.usuarios.domain.ports.out.AddressPersistencePort;
import com.arka.microservice.usuarios.infraestructure.driven.r2dbc.entity.AddressEntity;
import com.arka.microservice.usuarios.infraestructure.driven.r2dbc.mapper.IAddressEntityMapper;
import com.arka.microservice.usuarios.infraestructure.driven.r2dbc.mapper.IShippingAddressEntityMapper;
import com.arka.microservice.usuarios.infraestructure.driven.r2dbc.repository.IAddressRepository;
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
public class AddressAdapterImpl implements AddressPersistencePort {
    private final IAddressRepository repository;
    private final IAddressEntityMapper mapper;

    /**
     * Funcion que consulta un objeto por id
     * @param id identificador del objeto a buscar
     * @return retorna un objeto mapeado para dominio
     */
    @Override
    public Mono<AddressModel> findById(Long id) {
        return repository.findById(id)
                .map(mapper::toModel);
    }

    /**
     * Funcion que consulta todos los objetos y los mapea a modelo.
     * @return retorna todos los objetos mapeados para el dominio
     */
    @Override
    public Flux<AddressModel> findAll() {
        return repository.findAll()
                .map(mapper::toModel);
    }

    /**
     * Funcion que guarda un objeto
     * @param model objeto a guardar
     * @return retorna un objeto mapeado para el dominio
     */
    @Override
    public Mono<AddressModel> save(AddressModel model) {
        AddressEntity entity = mapper.toEntity(model);
        return repository.save(entity)
                .map(mapper::toModel);
    }

    /**
     * Funcion actualiza un objeto existente. Se busca por id
     * @param model objeto a actualizar, contiene un id en sus atributos
     * @return retorna un objeto mapeado para el dominio
     */
    @Override
    public Mono<AddressModel> update(AddressModel model) {
        AddressEntity entity = mapper.toEntity(model);
        return repository.save(entity)
                .map(mapper::toModel);
    }

    /**
     * Funcion que eliminar un objeto dado su id y retorna el Mono<Void> correspondiente.
     * @param id identificador del objeto a eliminar
     */
    @Override
    public Mono<Void> deleteById(Long id) {
        return repository.deleteById(id);
    }
}
