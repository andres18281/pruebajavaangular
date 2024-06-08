package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Deshabilitar CSRF para simplificar el ejemplo
            .authorizeHttpRequests(authz -> authz
                .requestMatchers("/api/clientes/**").permitAll() // Permitir acceso a /api/clientes sin autenticación
                .anyRequest().authenticated() // Requerir autenticación para cualquier otra ruta
            )
            .httpBasic(); // Usar autenticación HTTP básica

        return http.build();
    }
}