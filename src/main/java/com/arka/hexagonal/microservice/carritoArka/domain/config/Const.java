package com.arka.hexagonal.microservice.carritoArka.domain.config;

/**
 * Constantes del dominio
 */
public class Const {
    //GENERAL
    public static final String DB_EMPTY = "No se encontraron datos en la base de datos.";
    public static final String CONTROLLER_ID_NOT_CORRECT = "El ID del path no coincide con el ID del cuerpo.";

    //USER DOMAIN

    public static final String USER_NOT_FOUND = "Usuario no encontrado en la base de datos.";
    public static final String USER_NAME_NOT_FOUND = "No se encontraron coincidencias.";
    public static final String USER_TYPE_INCORRECT = "El tipo de usuario es incorrecto.";
    public static final String USER_FOUND = "Usuario encontrado en la base de datos.";
    public static final String INVALID_USER_TYPE = "El tipo de usuario proporcionado no es válido.";
    public static final String DNI_DUPLICATED = "El DNI del usuario ya está en uso.";
    public static final String UPDATE_FAILED = "No se pudo actualizar el usuario, revise los datos ingresados.";
    public static final String DELETE_FAILED = "No se pudo eliminar el usuario especificado.";

}
