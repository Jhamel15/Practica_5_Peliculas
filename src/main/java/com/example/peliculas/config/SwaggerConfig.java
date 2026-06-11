package com.example.peliculas.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

        @Bean
        public OpenAPI customOpenAPI() {

                Contact contacto = new Contact();
                contacto.setName("Jhamel Javier Pinto Ubaldes");
                contacto.setUrl("Universidad Autónoma Tomás Frías");

                return new OpenAPI()

                                .info(new Info()
                                                .title("API REST - Gestión de Películas")
                                                .version("1.0")
                                                .description(
                                                                "Práctica 6 - Backend Spring Boot\n\n" +
                                                                                "Tecnologías Emergentes SIS-414\n\n" +
                                                                                "CRUD completo de la entidad Película utilizando Spring Boot, PostgreSQL y Swagger.")
                                                .contact(contacto)
                                                .license(
                                                                new License()
                                                                                .name("Universidad Autónoma Tomás Frías")))

                                .externalDocs(
                                                new ExternalDocumentation()
                                                                .description("Tecnologías Emergentes - SIS 414"));
        }
}