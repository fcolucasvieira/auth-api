package com.fcolucasvieira.auth.infra.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {

        final String securitySchemeName = "bearerAuth";

        return new OpenAPI()
                .info(new Info()
                        .title("Spring Boot JWT Authentication API")
                        .version("1.0")
                        .description("""
REST API built with Spring Boot demonstrating secure authentication using JWT.

Features:
- User registration
- User login with JWT token generation
- Protected endpoints using Spring Security
- Product creation (authenticated)
- Paginated product listing (authenticated)

Technologies:
Spring Boot • Spring Security • JWT • Flyway • MapStruct • Swagger
""")
                        .contact(new Contact()
                                .name("Lucas Vieira")
                                .email("fclucasvieira@gmail.com")
                                .url("https://github.com/fcolucasvieira/auth-api.git")
                        )
                )
                .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
                .components(
                        new Components()
                                .addSecuritySchemes(
                                        securitySchemeName,
                                        new SecurityScheme()
                                                .name(securitySchemeName)
                                                .type(SecurityScheme.Type.HTTP)
                                                .scheme("bearer")
                                                .bearerFormat("JWT")
                                )
                );
    }
}
