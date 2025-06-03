package com.healthcare.vitalsigns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
    info = @Info(
        title = "Vital Signs API",
        version = "1.0",
        description = "REST API for managing patient vital signs"
    )
)
public class VitalSignsApplication {
    public static void main(String[] args) {
        SpringApplication.run(VitalSignsApplication.class, args);
    }
} 