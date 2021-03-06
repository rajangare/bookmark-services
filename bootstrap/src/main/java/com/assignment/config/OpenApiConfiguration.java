package com.assignment.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI customOpenAPI(@Value("3.0") String appVersion) {
        return new OpenAPI().info(new Info().title("Bookmark Management API Documentation")
                .version(appVersion)
                .description("Bookmark  management API documentation on OPEN API 3.0" +
                        "<br />" +
                        "<a href='http://localhost:8090/h2-console/login.jsp' target=blank>H2 Database URL</a>")
                .termsOfService("http://swagger.io/terms/")
                .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}
