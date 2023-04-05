package tz.co.vodacom.bujikun.sportyshoes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tz.co.vodacom.bujikun.sportyshoes.service.UserService;

@Controller
@RequestMapping(value = {"/users","/users/"})
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping
    public String index(Model model){
        var users = userService.findAll();
        model.addAttribute("users",users);
        return "user/index";
    }

    @PostMapping("/search")
    public String search(@RequestParam("search")String queryString, Model model){
        var users = userService.search(queryString);
        model.addAttribute("users",users);
        return "user/index";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable("id")Integer id, Model model){
        var user= userService.findById(id);
        var permissions = user.getRoles().stream().flatMap(r->r.getPermissions().stream().map(p->p.getName())).toList();
        model.addAttribute("user",user);
        model.addAttribute("userOrders",user.getOrders());
        model.addAttribute("userPermissions",permissions);
        return "user/view";
    }
}
