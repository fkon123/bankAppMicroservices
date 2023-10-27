package com.microservices.accounts;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
/*
 * @ComponentScans({ @ComponentScan(
 * "com.microservices.accounts.controller") })
 *
 * @EnableJpaRepositories("com.microservices.accounts.repository")
 *
 * @EntityScan("com.microservices.accounts.model")
 */
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(info = @Info(title = "Accounts microservice REST API Documentation", description = "Bank Accounts microservice REST API Documentation", version = "v1" ), externalDocs = @ExternalDocumentation(description = "microservicesBank Accounts microservice REST API Documentation"))
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}