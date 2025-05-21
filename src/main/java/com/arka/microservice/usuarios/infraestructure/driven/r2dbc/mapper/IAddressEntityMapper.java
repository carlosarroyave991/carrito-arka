package com.arka.microservice.usuarios.infraestructure.driven.r2dbc.mapper;

import com.arka.microservice.usuarios.domain.models.AddressModel;
import com.arka.microservice.usuarios.infraestructure.driven.r2dbc.entity.AddressEntity;
import org.mapstruct.*;


@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface IAddressEntityMapper {

    AddressEntity toEntity(AddressModel model);

    @InheritInverseConfiguration
    AddressModel toModel(AddressEntity entity);
}
