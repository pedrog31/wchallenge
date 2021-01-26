package com.co.wchallenge.sistema.seguridad.configuracion;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MapeoCorsSeguridad implements WebMvcConfigurer {

	@Value("${seguridad.permitir-origenes}")
	private String origenesPermitidos;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedHeaders("*")
				.allowedOrigins(origenesPermitidos.split(","))
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH");
    }
}