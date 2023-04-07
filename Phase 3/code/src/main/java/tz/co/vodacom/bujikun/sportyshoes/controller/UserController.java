package tz.co.vodacom.bujikun.sportyshoes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
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
    @PreAuthorize("hasAuthority(T(tz.co.vodacom.bujikun.sportyshoes.enumeration.PermissionName).USER_VIEW_ALL.value)")
    public String index(Model model){
        var users = userService.findAll();
        model.addAttribute("users",users);
        return "user/index";
    }

    @PostMapping("/search")
    @PreAuthorize("hasAuthority(T(tz.co.vodacom.bujikun.sportyshoes.enumeration.PermissionName).USER_VIEW_ALL.value)")
    public String search(@RequestParam("search")String queryString, Model model){
        var users = userService.search(queryString);
        model.addAttribute("users",users);
        return "user/index";
    }

    @GetMapping("/view/{id}")
    @PreAuthorize("hasAuthority(T(tz.co.vodacom.bujikun.sportyshoes.enumeration.PermissionName).USER_VIEW.value)")
    public String view(@PathVariable("id")Integer id, Model model){
        var user= userService.findById(id);
        var permissions = user.getRoles().stream().flatMap(r->r.getPermissions().stream().map(p->p.getName())).toList();
        model.addAttribute("user",user);
        model.addAttribute("userOrders",user.getOrders());
        model.addAttribute("userPermissions",permissions);
        model.addAttribute("isAdmin",user.getRoles().stream()
                .map(r->r.getName()).toList().contains("ADMIN"));
        model.addAttribute("isSuperAdmin",user.getRoles().stream()
                .map(r->r.getName()).toList().contains("SUPERADMIN"));
        return "user/view";
    }

    @PostMapping("/make-admin")
    @PreAuthorize("hasAuthority(T(tz.co.vodacom.bujikun.sportyshoes.enumeration.PermissionName).ADMIN_ADD.value)")
    public String makeAdmin(@RequestParam("userId")Integer userID){
        userService.makeAdmin(userID);
        return "redirect:/users/view/"+userID;
    }
    @PostMapping("/revoke-admin")
    @PreAuthorize("hasAuthority(T(tz.co.vodacom.bujikun.sportyshoes.enumeration.PermissionName).ADMIN_ADD.value)")
    public String revokeAdmin(@RequestParam("userId")Integer userID){
        userService.revokeAdmin(userID);
        return "redirect:/users/view/"+userID;
    }
}
