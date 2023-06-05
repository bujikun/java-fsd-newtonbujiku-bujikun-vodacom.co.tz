package tz.co.vodacom.bujikun.kitchenstories.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import tz.co.vodacom.bujikun.kitchenstories.dto.PasswordChangeDTO;
import tz.co.vodacom.bujikun.kitchenstories.service.UserService;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/change-password")
    @PreAuthorize("hasAuthority('user:change-password')")
    public ResponseEntity<String> changePassword(@RequestBody PasswordChangeDTO passwordChangeDTO,
                                                 JwtAuthenticationToken jwtAuthenticationToken){
        String username = jwtAuthenticationToken.getToken().getSubject();
        System.out.println(passwordChangeDTO);
        if(!username.equals(passwordChangeDTO.getUsername())){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Not your token");
        }
        userService.changePassword(passwordChangeDTO);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body("Password Changed! Invalid old password");
    }

}
