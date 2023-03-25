package tz.co.vodacom.bujikun.sportyshoes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tz.co.vodacom.bujikun.sportyshoes.service.CategoryService;
import tz.co.vodacom.bujikun.sportyshoes.service.ProductService;

import java.util.stream.Collectors;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    //private final CategoryService categoryService;
    @GetMapping
    public String getAll(Model model){

        model.addAttribute("products",productService.findAll());
//        model.addAttribute("categories", categoryService.findAll().stream()
//                .map(c->c.getName()).collect(Collectors.joining(",")));
        return "product/index";
    }
}
