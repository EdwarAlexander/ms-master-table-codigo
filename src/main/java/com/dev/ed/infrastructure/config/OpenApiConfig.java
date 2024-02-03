package com.dev.ed.infrastructure.config;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(title = "Trabajo final de Backend - Codigo", version = "1.0",
                description = "documentacion de endpoint - Software de captación del cliente",
                contact = @io.swagger.v3.oas.annotations.info.Contact(name = "Edwar Moran", email = "dev.ed@deved.com")
        )
)
public class OpenApiConfig {
}
