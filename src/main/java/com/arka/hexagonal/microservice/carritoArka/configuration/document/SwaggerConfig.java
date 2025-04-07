package com.arka.hexagonal.microservice.carritoArka.configuration.document;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Gestión de Carrito de Compras")
                        .description("Documentación de la API para carrito de compras")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Carlos Andres Arroyave Ladino")
                                .email("carlosarroyave991@gmail.com")
                                .url("https://carrito.arroyave.com")))
                .servers(List.of(
                        new Server().url("http://localhost:8080").description("Servidor Local")
                ));
    }
}
