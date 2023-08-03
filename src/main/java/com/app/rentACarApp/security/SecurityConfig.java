package com.app.rentACarApp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {

    @Bean
    public JwtAuthConverterProperties jwtAuthConverterProperties(){
        return new JwtAuthConverterProperties();
    }

}
