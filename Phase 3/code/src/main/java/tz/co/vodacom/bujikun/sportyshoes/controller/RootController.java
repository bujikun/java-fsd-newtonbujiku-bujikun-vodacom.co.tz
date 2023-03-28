package tz.co.vodacom.bujikun.sportyshoes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import tz.co.vodacom.bujikun.sportyshoes.service.CategoryService;

@Controller
@RequiredArgsConstructor
public class RootController {
    private final CategoryService categoryService;
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("categories",categoryService.findAll());
        return "index";
    }
}
