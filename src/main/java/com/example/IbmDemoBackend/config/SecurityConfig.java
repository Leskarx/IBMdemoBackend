package com.example.IbmDemoBackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
    return config.getAuthenticationManager();
}


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // disable CSRF for REST APIs
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/api/user",
                    "/api/health",
                    "/api/auth/login"
                ).permitAll() // ✅ Allow access to /api/user
                .anyRequest().authenticated() // 🔒 Everything else requires login
            );
        return http.build();
    }
}
