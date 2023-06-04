package tz.co.vodacom.bujikun.kitchenstories.security.config;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.UUID;

@Configuration(proxyBeanMethods = false)
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity httpSecurity,
            JwtDecoder jwtDecoder

    ) throws Exception {
        httpSecurity
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(
                        reqs -> reqs
                                .requestMatchers(HttpMethod.POST,"/auth/login").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/foods", "/api/foods/search", "/api/foods/{id}")
                                .permitAll()
                                .requestMatchers(HttpMethod.POST, "/api/orders").permitAll()
                                //.requestMatchers("/api/customers")
                                .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .oauth2ResourceServer(ors -> ors
                        .jwt(jwt ->jwt
                                //jwt.jwtAuthenticationConverter(null)
                                .decoder(jwtDecoder)
                        )
                );

        return httpSecurity.build();
    }

    @Bean
    public JwtDecoder jwtDecoder(ImmutableJWKSet<SecurityContext> immutableJWKSet) throws JOSEException {
        RSAKey key = immutableJWKSet.getJWKSet().getKeys().get(0).toRSAKey();
        return  NimbusJwtDecoder.withPublicKey(key.toRSAPublicKey()).build();
    }

    @Bean
    public JwtEncoder jwtEncoder(ImmutableJWKSet<SecurityContext> immutableJWKSet)  {
        return new NimbusJwtEncoder(immutableJWKSet);
    }

    @Bean
    public ImmutableJWKSet<SecurityContext> immutableJWKSet() throws NoSuchAlgorithmException {
        //generate rsa key pair
        KeyPairGenerator kp = KeyPairGenerator.getInstance("RSA");
        kp.initialize(2048);
        KeyPair k = kp.generateKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey) k.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) k.getPrivate();
        JWK jwk =  new RSAKey.Builder(publicKey)
                .privateKey(privateKey)
                .keyID(UUID.randomUUID().toString())
                .build();
        return new ImmutableJWKSet<>(new JWKSet(jwk));
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(
            PasswordEncoder passwordEncoder,
            UserDetailsService userDetailsService
            ){
        var dap = new DaoAuthenticationProvider();
        dap.setPasswordEncoder(passwordEncoder);
        dap.setUserDetailsService(userDetailsService);
        return dap;
    }
}
