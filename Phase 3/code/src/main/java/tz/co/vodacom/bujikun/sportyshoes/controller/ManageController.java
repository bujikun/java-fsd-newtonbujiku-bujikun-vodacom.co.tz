package tz.co.vodacom.bujikun.sportyshoes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tz.co.vodacom.bujikun.sportyshoes.security.CustomUserDetails;
import tz.co.vodacom.bujikun.sportyshoes.service.UserService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/manage")
public class ManageController {
    private final UserService userService;
    @GetMapping
    @PreAuthorize("hasAuthority(T(tz.co.vodacom.bujikun.sportyshoes.enumeration.PermissionName).MANAGE_VIEW.value)")
    public String index(Model model){
        model.addAttribute("error",false);
        return "manage/index";
    }
    @PostMapping("/change-password")
    @PreAuthorize("hasAuthority(T(tz.co.vodacom.bujikun.sportyshoes.enumeration.PermissionName).USER_CHANGE_PASSWORD.value)")
    public String changePassword(@RequestParam("newPassword") String newPassword,
                                 @RequestParam("currentPassword") String currentPassword,
                                 Authentication authentication, Model model){
        var userId = ((CustomUserDetails)authentication.getPrincipal()).getUser().getId();
        var passwordUpdated = userService.isPasswordUpdated(currentPassword,newPassword,userId);
        boolean error = false;
        boolean success = false;
        //
        if(passwordUpdated){
            success =true;
            model.addAttribute("successMessage","Password Changed Successfully!.");
        }else{
            error = true;
            model.addAttribute("errorMessage","Password Change Failed! Invalid current password supplied.");
        }
        model.addAttribute("error",error);
        model.addAttribute("success",success);

        return "manage/index";
    }
}

