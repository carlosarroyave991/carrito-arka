package com.arka.microservice.usuarios.infraestructure.driver.rest.mapper;

import com.arka.microservice.usuarios.domain.models.AddressModel;
import com.arka.microservice.usuarios.infraestructure.driver.rest.dto.user.req.AddressRequestDto;
import com.arka.microservice.usuarios.infraestructure.driver.rest.dto.user.resp.AddressResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface IAddressMapperDto {

    AddressModel toModel(AddressRequestDto request);

    AddressResponseDto toResponse(AddressModel model);
}
