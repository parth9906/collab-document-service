package com.parth_collab.document_service.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .cors(cors -> {}) // CORS handled by Gateway
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // trust Gateway JWT
                );

        return http.build();
    }
}

