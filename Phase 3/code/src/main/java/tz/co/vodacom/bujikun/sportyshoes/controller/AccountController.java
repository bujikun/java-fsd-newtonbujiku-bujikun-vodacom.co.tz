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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tz.co.vodacom.bujikun.sportyshoes.entity.User;
import tz.co.vodacom.bujikun.sportyshoes.security.CustomUserDetails;
import tz.co.vodacom.bujikun.sportyshoes.service.UserService;

import java.util.Arrays;
import java.util.UUID;

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
    public String getRegister(Model model) {
        var user = new User();
        var accountNumber = UUID.randomUUID().toString().toUpperCase();
        user.setPaymentAccountNumber(accountNumber);
        model.addAttribute("user",user);
        model.addAttribute("accountNumber",accountNumber);
        return "account/register";
    }

    @PostMapping("/register")
    public String postRegister(
            @ModelAttribute("user") User user,
            HttpServletRequest request
    ) throws ServletException {
        var plainPassword = user.getPassword();
        userService.createNew(user);
        request.login(user.getUsername(),plainPassword);
        return "redirect:/";
    }
}
