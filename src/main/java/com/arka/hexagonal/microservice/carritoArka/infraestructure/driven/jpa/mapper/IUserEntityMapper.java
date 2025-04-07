package com.arka.hexagonal.microservice.carritoArka.infraestructure.driven.jpa.mapper;

import com.arka.hexagonal.microservice.carritoArka.domain.models.UserModel;
import com.arka.hexagonal.microservice.carritoArka.infraestructure.driven.jpa.entity.UserEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface IUserEntityMapper {
    @Mapping(target = "name", source = "name")
    @Mapping(target = "userType", source = "userType")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "phone", source = "phone")
    @Mapping(target = "dni", source = "dni")
    UserEntity toEntity(UserModel model);

    @Mapping(target = "name", source = "name")
    @Mapping(target = "userType", source = "userType")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "phone", source = "phone")
    @Mapping(target = "dni", source = "dni")
    UserModel toModel(UserEntity entity);
    List<UserModel> toModels(List<UserEntity> entities);
}
