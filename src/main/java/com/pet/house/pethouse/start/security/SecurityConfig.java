package com.pet.house.pethouse.start.security;

import jakarta.servlet.FilterChain;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
@Bean
    public BCryptPasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
}

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http
                    .csrf().disable()

                    .authorizeHttpRequests(authorize -> authorize
                            .requestMatchers(HttpMethod.POST,"/Vets/createVet").permitAll()
                            .anyRequest().permitAll()
                    );

            return http.build();
        }

    }
