package tz.co.vodacom.bujikun.sportyshoes.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.header.writers.ClearSiteDataHeaderWriter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tz.co.vodacom.bujikun.sportyshoes.entity.User;
import tz.co.vodacom.bujikun.sportyshoes.security.CustomUserDetails;
import tz.co.vodacom.bujikun.sportyshoes.service.UserService;

import java.util.Arrays;

@Controller
@RequiredArgsConstructor
public class AccountController {
    private final UserService userService;
    private final DaoAuthenticationProvider daoAuthenticationProvider;

    @GetMapping("/login")
    public String getLogin(@RequestParam(name = "error", required = false) String error, Model model) {
        if (error != null && error.equals("true")) {
            model.addAttribute("error", true);
            model.addAttribute("errorMessage", "Invalid username or password!");
        } else {
            model.addAttribute("error", false);
        }
        return "account/login";
    }

    @GetMapping("/register")
    public String getRegister() {
        return "account/register";
    }

    @PostMapping("/register")
    public String postRegister(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpServletRequest request
    ) throws ServletException {
        var user = userService.registerUser(username, password);
        request.login(username, password);
        return "redirect:/";
    }
}
