package com.app.rentACarApp.security;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
@RequiredArgsConstructor
public class JwtAuthConverterProperties {

    @Value("${resource-id}")
    private String resourceId;

    @Value("${principal-attribute}")
    private String principalAttribute;


}
