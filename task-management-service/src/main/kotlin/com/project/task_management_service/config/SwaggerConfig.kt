package com.project.task_management_service.config

import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {
    @Bean
    fun customOpenApi(): GroupedOpenApi {
        return GroupedOpenApi.builder()
            .group("task-management-service")
            .packagesToScan("com.project.task-management-service.controller")
            .build()
    }
}