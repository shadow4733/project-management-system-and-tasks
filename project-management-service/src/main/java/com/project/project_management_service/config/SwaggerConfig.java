package com.project.project_management_service.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi customOpenApi(){
        return GroupedOpenApi.builder()
                .group("user-service")
                .packagesToScan("com.project.project_management_service.controller")
                .build();
    }
}
