package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {

	 @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/api/**")
	                .allowedOrigins("*")  // Permitir cualquier origen
	                .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD")
	                .allowedHeaders("*"); // No permitir el intercambio de credenciales si no es necesario
	    }
}

