package tz.co.vodacom.bujikun.kitchenstories.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;
import tz.co.vodacom.bujikun.kitchenstories.security.model.SecurityUserDetails;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class TokenService {
    private final JwtEncoder jwtEncoder;
    public String generateToken(Authentication authentication){
        var ud = (SecurityUserDetails) authentication.getPrincipal();
        JwtClaimsSet claims  =  JwtClaimsSet.builder()
                .issuer("http://localhost:8080")
                .subject(ud.getUsername())
                .issuedAt(Instant.now())
                .expiresAt(Instant.now().plus(10, ChronoUnit.MINUTES))
                .audience(Collections.singletonList("http://localhost:8080"))
                .claim("permissions",ud.getAuthorities().stream().map(s-> s.getAuthority()).toList())
                .build();
        System.out.println(authentication.getAuthorities());
        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }
}
