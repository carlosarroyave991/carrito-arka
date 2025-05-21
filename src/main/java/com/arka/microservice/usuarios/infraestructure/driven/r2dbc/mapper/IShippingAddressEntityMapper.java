package com.arka.microservice.usuarios.infraestructure.driven.r2dbc.mapper;

import com.arka.microservice.usuarios.domain.models.ShippingAddressModel;
import com.arka.microservice.usuarios.infraestructure.driven.r2dbc.entity.ShippingAddressEntity;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface IShippingAddressEntityMapper {

    ShippingAddressEntity toEntity(ShippingAddressModel model);

    @InheritInverseConfiguration
    ShippingAddressModel toModel(ShippingAddressEntity entity);
}
