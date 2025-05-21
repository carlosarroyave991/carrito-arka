package com.arka.microservice.usuarios.infraestructure.config.utils;

import com.arka.microservice.usuarios.domain.ports.out.UserPersistencePort;
import com.arka.microservice.usuarios.infraestructure.driven.r2dbc.adapter.UserAdapterImpl;
import com.arka.microservice.usuarios.infraestructure.driven.r2dbc.mapper.IUserEntityMapper;
import com.arka.microservice.usuarios.infraestructure.driven.r2dbc.repository.IUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuracion que interactua con el nucleo de la aplicacion atravez de UserPersistencePort
 */
/*@Configuration
public class UserBeanConfiguration {
    private final IUserRepository repository; // Repositorio reactivo de usuarios
    private final IUserEntityMapper entityMapper; //mapper para convertir de dto a entity

    public UserBeanConfiguration(IUserRepository repository, IUserEntityMapper entityMapper) {
        this.repository = repository;
        this.entityMapper = entityMapper;
    }

    *//**
     * Configura el punto de entrada para interactuar con la capa de dominio.
     * Se expone como un bean para poder ser inyectado y usado en otros componentes.
     *
     * @return el UserAdapterImpl como un bean que implementa UserPersistencePort
     **//*
    @Bean
    public UserPersistencePort userServiceGateway(){
        return new UserAdapterImpl(repository, entityMapper);
    }
}*/
