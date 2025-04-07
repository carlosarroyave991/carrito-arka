package com.arka.hexagonal.microservice.carritoArka.application.usecases;



import com.arka.hexagonal.microservice.carritoArka.domain.models.UserModel;
import com.arka.hexagonal.microservice.carritoArka.domain.models.enums.UserType;
import com.arka.hexagonal.microservice.carritoArka.domain.ports.in.IUserPortUseCase;
import com.arka.hexagonal.microservice.carritoArka.domain.ports.out.UserServicePort;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.arka.hexagonal.microservice.carritoArka.domain.config.Const.*;

/**
 * Clase usada para implementar la logica de negocio sobre cada funcion
 */
@Service
public class UserUseCaseImpl implements IUserPortUseCase {
    private final UserServicePort servicePort;

    public UserUseCaseImpl(UserServicePort servicePort) {
        this.servicePort = servicePort;
    }

    /**
     * Servicio para obtener un user especifico
     * @param id parametro usado para la consulta del user
     * @return retorna un objeto en especifico
     */
    @Override
    public Optional<UserModel> getUserById(Long id) {
        Optional<UserModel> optional = servicePort.findById(id);
        if (optional.isEmpty())throw new IllegalArgumentException(USER_NOT_FOUND);
        return optional;
    }

    /**
     * Servicio para buscar user por nombre
     * @param name nombre de la persona a buscar
     * @return retorna una lista de objetos con el mismo nombre
     */
    @Override
    public Optional<List<UserModel>> getUsersByName(String name) {
        Optional<List<UserModel>> models = servicePort.findByName(name);
        if (models.isEmpty()) throw new IllegalArgumentException(USER_NAME_NOT_FOUND);
        return models;
    }

    /**
     * Servicio que obtiene todos los clientes existentes
     * @return retorna una lista de objetos
     */
    @Override
    public List<UserModel> getAllUsers() {
        List<UserModel> models = servicePort.findAll();
        if (models.isEmpty()){
            throw new IllegalArgumentException(DB_EMPTY);
        }else{
            return models;
        }
    }

    /**
     * servicio usado para guardar un user o crearlo
     * @param model objeto user con los parametros necesarios para la creacion
     * @return objeto user creado
     */
    @Transactional
    @Override
    public UserModel createUser(UserModel model){
        //Validar si el dni ya existe
        Optional<UserModel> optional = servicePort.findByDni(model.getDni());
        if (optional.isPresent()) throw new IllegalArgumentException(DNI_DUPLICATED);

        // Asignar tipoUsuario por defecto si no está definido
        model.setUserType(model.getUserType() != null ? model.getUserType() : UserType.cliente);
        //Validar el tipoUsuario
        if (!userTypeIsValid(model.getUserType())) throw new IllegalArgumentException(USER_TYPE_INCORRECT);

        return servicePort.save(model);
    }

    // Método auxiliar para validar tipoUsuario
    private boolean userTypeIsValid(UserType userType) {
        // Verifica si el tipoUsuario pertenece a los valores definidos en el enum
        return Arrays.stream(UserType.values()).anyMatch(tipo -> tipo == userType);
    }

    /**
     * Servicio que permite actualizar un cliente en especifico
     * @param user objeto con los datos a actualizar
     * @return retorna el objeto actualizado
     */
    @Transactional
    @Override
    public UserModel updateUser(UserModel user, Long id) {
        Optional<UserModel> model = servicePort.findById(id);
        if (model.isEmpty()) throw new IllegalArgumentException(USER_NOT_FOUND);
        return servicePort.update(user, id);
    }

    /**
     * Servico para eliminar un cliente en especifico
     * @param id del cliente a eliminar
     */
    @Override
    public void deleteUser(Long id) {
        Optional<UserModel> model = servicePort.findById(id);
        if (model.isEmpty()) throw new IllegalArgumentException(DB_EMPTY);
        servicePort.deleteById(id);
    }
}
