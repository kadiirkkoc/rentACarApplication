package com.app.rentACarApp.utilities.config;


import com.app.rentACarApp.dtos.responses.ResponseDTO;
import com.app.rentACarApp.security.JwtAuthConverter;
import com.app.rentACarApp.security.JwtAuthConverterProperties;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }

    @Bean
    public ResponseDTO getResponseDTO(){
        return new ResponseDTO();
    }


}


