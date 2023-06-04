package tz.co.vodacom.bujikun.kitchenstories.security.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tz.co.vodacom.bujikun.kitchenstories.dto.AuthDTO;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class TokenController {
    @PostMapping("/token")
    public ResponseEntity<Boolean> create(@RequestBody AuthDTO loginDTO, HttpServletRequest req){
        System.out.println(loginDTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(true);
    }

}
