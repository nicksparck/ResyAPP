package com.universidadCentral.Resyapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class seguridadConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // <- forma correcta para desactivar CSRF en Spring Security 6.1+
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/rest/**").permitAll()
                        .requestMatchers("/autentificar/**").permitAll()
                        .anyRequest().authenticated()
                );

        return http.build();
    }
}
