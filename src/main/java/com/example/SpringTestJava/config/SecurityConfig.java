package com.example.SpringTestJava.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf.disable()) // disable CSRF for simplicity (adjust for production)
//                .authorizeHttpRequests(auth -> auth
////                                .requestMatchers("/h2-console/**").permitAll() // optional: allow H2 console
//                                .anyRequest().permitAll() // permit all endpoints
////                        .anyRequest().authenticated()
//                )
//                .headers(headers -> headers.frameOptions(frame -> frame.disable())); // allow frames for H2 console
//
//        return http.build();
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .antMatchers("/api/v1/**").permitAll()
                        .anyRequest().denyAll()
                );

        return http.build();
    }



}

