package tz.co.vodacom.bujikun.kitchenstories.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.security.oauth2.server.resource.InvalidBearerTokenException;
import org.springframework.stereotype.Service;
import tz.co.vodacom.bujikun.kitchenstories.security.entity.Token;
import tz.co.vodacom.bujikun.kitchenstories.security.model.SecurityUserDetails;
import tz.co.vodacom.bujikun.kitchenstories.security.repository.TokenRepository;
import tz.co.vodacom.bujikun.kitchenstories.util.DateUtil;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class TokenService {
    private final JwtEncoder jwtEncoder;
    private final TokenRepository tokenRepository;
    private final DateUtil dateUtil;
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
        String jwtTokenValue =  jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
        Token token = Token.builder()
                .value(jwtTokenValue)
                .username(ud.getUsername())
                .isInvalidated(false)
                .createdOn(dateUtil.now())
                .version(1)
                .build();
        tokenRepository.save(token);
        System.out.println(jwtTokenValue.length());
        return jwtTokenValue;
    }

    public Token findByValue(String value){
        return tokenRepository.findTokenByValue(value);
    }

    public Token findByUsername(String username){
        return tokenRepository.findTokenByValue(username);
    }

    public void invalidate(String username){
        tokenRepository.invalidateUserTokens(username,false);
    }


}
