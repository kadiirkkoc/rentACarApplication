package com.app.rentACarApp.security;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimNames;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@AllArgsConstructor
public class JwtAuthConverter implements Converter<Jwt, AbstractAuthenticationToken> {

    private final JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();;
    private final JwtAuthConverterProperties jwtAuthConverterProperties;

    @Override
    public AbstractAuthenticationToken convert(Jwt jwt) {
        Collection<GrantedAuthority> authorities = Stream.concat(
                jwtGrantedAuthoritiesConverter.convert(jwt).stream(),
                extractResourceRoles(jwt).stream()).collect(Collectors.toList());

        return new JwtAuthenticationToken(jwt,authorities,getPrincipalClaimName(jwt));
    }

    private String getPrincipalClaimName(Jwt jwt){
        String claimName = JwtClaimNames.SUB;
        if (jwtAuthConverterProperties.getPrincipalAttribute() != null){
            claimName = jwtAuthConverterProperties.getPrincipalAttribute();
        }
        return jwt.getClaim(claimName);
    }

    private Collection<? extends GrantedAuthority> extractResourceRoles(Jwt jwt){
        Map<String , Object> resourceAccess = jwt.getClaim("resource_access");
        Map<String , Object> resource;
        Collection<String> resourceRoles;

        if (resourceAccess == null
            || (resource = (Map<String,Object>) resourceAccess.get(jwtAuthConverterProperties.getResourceId())) == null
            || (resourceRoles = (Collection<String>) resource.get("roles")) == null){
            return Set.of();
        }

        return resourceRoles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                .collect(Collectors.toList());

    }
}
