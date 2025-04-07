package com.arka.hexagonal.microservice.carritoArka.infraestructure.config;

import com.arka.hexagonal.microservice.carritoArka.domain.ports.out.UserServicePort;
import com.arka.hexagonal.microservice.carritoArka.infraestructure.driven.jpa.mapper.IUserEntityMapper;
import com.arka.hexagonal.microservice.carritoArka.infraestructure.driven.jpa.repository.IUserRepository;
import com.arka.hexagonal.microservice.carritoArka.infraestructure.driven.jpa.service.UserAdapterImpl;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuracion que interactua con el nucleo de la aplicacion atravez de UserServicePort
 */
@Configuration
public class UserBeanConfiguration {
    private final IUserRepository repository; //repo de infra
    private final IUserEntityMapper entityMapper; //mapper para convertir de dto a entity

    public UserBeanConfiguration(IUserRepository repository, IUserEntityMapper entityMapper) {
        this.repository = repository;
        this.entityMapper = entityMapper;
    }

    /**
     * Configura el punto de entrada para interactuar con la capa de dominio
     * @return el UserAdapterImpl como un bean
     */
    @Bean
    public UserServicePort userServiceGateway(){
        return new UserAdapterImpl(repository, entityMapper);
    }
}
