package tz.co.vodacom.bujikun.kitchenstories.security.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import tz.co.vodacom.bujikun.kitchenstories.dto.AuthDTO;
import tz.co.vodacom.bujikun.kitchenstories.security.service.TokenService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class TokenController {
    private final TokenService tokenService;
    @PostMapping("/login")
    public ResponseEntity<String> create(Authentication authentication, HttpServletRequest req){
        //System.out.println(authentication);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(tokenService.generateToken(authentication));
    }

    @PostMapping("/invalidate")
    public ResponseEntity<String> invalidateToken(@RequestParam("username") String username){
        tokenService.invalidate(username);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Token invalidated");
    }
}
