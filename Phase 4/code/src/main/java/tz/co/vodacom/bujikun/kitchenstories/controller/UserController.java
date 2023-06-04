package tz.co.vodacom.bujikun.kitchenstories.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    @GetMapping
    public ResponseEntity<String> findAll(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Users Home");
    }

//    @PostMapping("/login")
//    public ResponseEntity<Boolean> create(@RequestBody LoginDTO loginDTO, HttpServletRequest req){
//
//        return ResponseEntity.status(HttpStatus.ACCEPTED)
//                .body(true);
//    }

}
