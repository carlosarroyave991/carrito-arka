package com.arka.microservice.usuarios.infraestructure.driven.r2dbc.mapper;

import com.arka.microservice.usuarios.domain.models.UserModel;
import com.arka.microservice.usuarios.infraestructure.driven.r2dbc.entity.UserEntity;
import org.mapstruct.*;
import reactor.core.publisher.Flux;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface IUserEntityMapper {

    UserEntity toEntity(UserModel model);

    // Invierte la configuración de toEntity de forma automática.
    @InheritInverseConfiguration
    UserModel toModel(UserEntity entity);

    // Método por defecto que opera sobre un Flux
    default Flux<UserModel> toModels(Flux<UserEntity> entityFlux){
        return entityFlux.map(this::toModel);
    }
    //Flux<UserModel> toModels(Flux<UserEntity> entities);
}
