package tz.co.vodacom.bujikun.sportyshoes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import tz.co.vodacom.bujikun.sportyshoes.service.UserService;

@Controller
@RequestMapping(value = {"/users","/users/"})
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
}
