package com.app.rentACarApp.utilities.config;


import com.app.rentACarApp.dtos.responses.ResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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


