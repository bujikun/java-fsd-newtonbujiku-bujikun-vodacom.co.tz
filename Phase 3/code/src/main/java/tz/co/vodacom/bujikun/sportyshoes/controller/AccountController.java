package tz.co.vodacom.bujikun.sportyshoes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AccountController {
    @GetMapping("/login")
    public String getLogin(){
        return "account/login";
    }

    @GetMapping("/register")
    public String getRegister(){
        return "account/register";
    }
}
