package com.arka.hexagonal.microservice.carritoArka.infraestructure.driver.rest.mapper;

import com.arka.hexagonal.microservice.carritoArka.domain.models.UserModel;
import com.arka.hexagonal.microservice.carritoArka.infraestructure.driver.rest.dto.user.req.UserRequestDto;
import com.arka.hexagonal.microservice.carritoArka.infraestructure.driver.rest.dto.user.resp.UserResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;



@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface IUserMapperDto {
    //Convierte un UserRequestDto a un UserModel para el dominio.
    UserModel toModel(UserRequestDto dto);

    UserRequestDto toRequestSimple(UserModel model);

    UserResponseDto toResponseWithoutId(UserModel model);

    //Listas bidireccionales
    List<UserResponseDto> toResponseDtos(List<UserModel> models);
    List<UserModel> toModels(List<UserRequestDto> dtos);
}
