package tz.co.vodacom.bujikun.sportyshoes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tz.co.vodacom.bujikun.sportyshoes.service.ProductService;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = {"/stock","/stock/"})
public class StockController {
    private final ProductService productService;

    @GetMapping
    public String index(Model model){
        var products = productService.findAll();
        model.addAttribute("products",products);
        return "stock/index";
    }

}
