package com.arka.hexagonal.microservice.carritoArka.infraestructure.driver.rest.controller;

import com.arka.hexagonal.microservice.carritoArka.configuration.helpers.ResponseHelper;
import com.arka.hexagonal.microservice.carritoArka.domain.models.UserModel;
import com.arka.hexagonal.microservice.carritoArka.domain.ports.in.IUserPortUseCase;
import com.arka.hexagonal.microservice.carritoArka.domain.ports.out.UserServicePort;
import com.arka.hexagonal.microservice.carritoArka.infraestructure.driver.rest.dto.user.req.UserRequestDto;
import com.arka.hexagonal.microservice.carritoArka.infraestructure.driver.rest.dto.user.resp.UserResponseDto;
import com.arka.hexagonal.microservice.carritoArka.infraestructure.driver.rest.mapper.IUserMapperDto;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.arka.hexagonal.microservice.carritoArka.domain.config.Const.CONTROLLER_ID_NOT_CORRECT;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final IUserPortUseCase serviceUseCase; //capa de dominio, puerto out
    private final IUserMapperDto mapperDto;//mapper rest

    public UserController(IUserPortUseCase serviceUseCase, IUserMapperDto mapperDto) {
        this.serviceUseCase = serviceUseCase;
        this.mapperDto = mapperDto;
    }

    /**
     * Endpoint para obtener un usuario por su ID.
     * @param id ID del usuario a consultar.
     * @return Usuario encontrado o respuesta 404 si no se encuentra.
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable("id")Long id){
        Optional<UserModel> model = serviceUseCase.getUserById(id);
        return model
                .map(user -> ResponseEntity.ok(mapperDto.toResponseWithoutId(user)))
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Endpoint para obtener usuarios por nombre.
     * @param name Nombre del usuario a buscar.
     * @return Lista de usuarios con el nombre especificado.
     */
    @GetMapping("/name")
    public ResponseEntity<List<UserResponseDto>> getUsersByName(@RequestParam String name){
        Optional<List<UserModel>> models = serviceUseCase.getUsersByName(name);
        List<UserResponseDto> response = mapperDto.toResponseDtos(models.get());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Endpoint para crear un usuario.
     * @Valid valida automaticamente los datos que llegan en el request
     * @param userRequestDto Datos del usuario a crear.
     * @return Usuario creado con código 201.
     */
    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@Valid @RequestBody UserRequestDto userRequestDto) {
        UserModel userModel = mapperDto.toModel(userRequestDto);
        UserModel createdUser = serviceUseCase.createUser(userModel);
        UserResponseDto response = mapperDto.toResponseWithoutId(createdUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * Endpoint para actualizar un usuario.
     * @param id ID del usuario a actualizar.
     * @param requestDto Datos del usuario actualizados.
     * @return Usuario actualizado.
     */
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUser(
            @PathVariable("id") Long id,
            @Valid @RequestBody UserRequestDto requestDto
    ){
        UserModel model = mapperDto.toModel(requestDto);
        UserModel updateUser = serviceUseCase.updateUser(model, id);
        UserResponseDto response = mapperDto.toResponseWithoutId(updateUser);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Endpoint para eliminar un usuario por su ID.
     * @param id ID del usuario a eliminar.
     * @return Respuesta 204 si se elimina correctamente.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        serviceUseCase.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Endpoint para obtener todos los usuarios.
     * @return Lista de todos los usuarios.
     */
    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers(){
        List<UserModel> models = serviceUseCase.getAllUsers();
        List<UserResponseDto> response = mapperDto.toResponseDtos(models);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
