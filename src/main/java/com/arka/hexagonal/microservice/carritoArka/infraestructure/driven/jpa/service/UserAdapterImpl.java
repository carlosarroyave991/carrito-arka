package com.arka.hexagonal.microservice.carritoArka.infraestructure.driven.jpa.service;

import com.arka.hexagonal.microservice.carritoArka.domain.models.UserModel;
import com.arka.hexagonal.microservice.carritoArka.domain.ports.out.UserServicePort;
import com.arka.hexagonal.microservice.carritoArka.infraestructure.driven.jpa.entity.UserEntity;
import com.arka.hexagonal.microservice.carritoArka.infraestructure.driven.jpa.mapper.IUserEntityMapper;
import com.arka.hexagonal.microservice.carritoArka.infraestructure.driven.jpa.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * El adaptador se encargara de conectar ambas capas, pasando la informacion de la entidad
 * al modelo de dominio.
 */
public class UserAdapterImpl implements UserServicePort {
    private final IUserRepository repository;
    private final IUserEntityMapper mapper;

    public UserAdapterImpl(IUserRepository repository, IUserEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * Funcion que consulta un objeto por id
     * @param id identificador el objeto a buscar
     * @return retorna un objeto mapeado para dominio
     */
    @Override
    public Optional<UserModel> findById(Long id) {
        Optional<UserEntity> entity = repository.findById(id);
        return entity.map(mapper::toModel);//convierto mi entidad en modelo
    }

    /**
     * Funcion que consulta objetos por name
     * @param name nombre de los objetos a buscar
     * @return retorna una lista de objetos mapeados para el dominio
     */
    @Override
    public Optional<List<UserModel>> findByName(String name) {
        Optional<List<UserEntity>> entities = (repository.findByNameContaining(name));
        return entities.map(mapper::toModels);
    }

    /**
     * Funcion que consulta un objeto por dni
     * @param dni identificador el objeto a buscar
     * @return retorna un objeto mapeado para dominio
     */
    @Override
    public Optional<UserModel> findByDni(String dni) {
        Optional<UserEntity> entity = repository.findByDni(dni);
        return entity.map(mapper::toModel);
    }

    /**
     * Funcion que consulta todos los objetos
     * @return retorna todos los objetos mapeados para el dominio
     */
    @Override
    public List<UserModel> findAll() {
        List<UserEntity> entities = repository.findAll();
        return mapper.toModels(entities);
    }

    /**
     * Funcion que guarda un objeto
     * @param user objeto a guardar
     * @return retorna un objeto mapeado para el dominio
     */
    @Override
    public UserModel save(UserModel user) {
        UserEntity entity = mapper.toEntity(user);//convierto el modelo a entity para guardarlo
        return mapper.toModel(repository.save(entity));//retorno el objeto al dominio luego de guardarlo
    }

    /**
     * Funcion que actualiza un objeto, la diferencia es que este trae el id en sus atributos
     * @param user objeto a actualizar, contiene un id en sus atributos
     * @return retorna un objeto mapeado para el dominio
     */
    @Override
    public UserModel update(UserModel user, Long id) {
        //Obtenemos el usuario a actualizar
        Optional<UserEntity> existingUser = repository.findById(id);
        //Al objeto encontrado le pasamos los nuevos atributos
        UserEntity entityToUpdate = existingUser.get();
        if (user.getName() != null)entityToUpdate.setName(user.getName());
        if (user.getEmail() != null)entityToUpdate.setEmail(user.getEmail());
        if (user.getUserType() != null)entityToUpdate.setUserType(user.getUserType());
        if (user.getDni() != null)entityToUpdate.setDni(user.getDni());
        if (user.getPhone() != null)entityToUpdate.setPhone(user.getPhone());
        //guardo en db, y mapeo a la vez de entity a model(response)
        return mapper.toModel(repository.save(entityToUpdate));
        /*entityToUpdate = mapper.toEntity(user);
        return mapper.toModel(repository.save(entityToUpdate));*/

    }

    /**
     * Funcion que eliminar un objeto
     * @param id identificador del objeto a eliminar
     */
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
