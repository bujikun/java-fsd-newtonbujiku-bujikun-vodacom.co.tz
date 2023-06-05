package tz.co.vodacom.bujikun.kitchenstories.security.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class JWTAuthConverter implements Converter<Jwt, AbstractAuthenticationToken> {
    @Override
    public AbstractAuthenticationToken convert(Jwt jwt) {
        Set<SimpleGrantedAuthority> authorities = ((ArrayList<String>)jwt.getClaim("permissions")).stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toUnmodifiableSet());
        JwtAuthenticationToken jwtAuthenticationToken = new JwtAuthenticationToken(jwt,authorities);
        return jwtAuthenticationToken;
    }
}
