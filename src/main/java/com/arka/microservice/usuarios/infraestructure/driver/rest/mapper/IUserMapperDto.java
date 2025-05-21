package com.arka.microservice.usuarios.infraestructure.driver.rest.mapper;

import com.arka.microservice.usuarios.domain.models.UserModel;
import com.arka.microservice.usuarios.infraestructure.driver.rest.dto.user.req.AuthRequestDto;
import com.arka.microservice.usuarios.infraestructure.driver.rest.dto.user.req.UserRequestDto;
import com.arka.microservice.usuarios.infraestructure.driver.rest.dto.user.resp.UserResponseDto;
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

    UserResponseDto toResponseWithoutId(UserModel model);

    //AuthRequest -> Model
    UserModel authReqtoModel(AuthRequestDto dto);

    //Listas bidireccionales
    List<UserResponseDto> toResponseDtos(List<UserModel> models);
    List<UserModel> toModels(List<UserRequestDto> dtos);
}
