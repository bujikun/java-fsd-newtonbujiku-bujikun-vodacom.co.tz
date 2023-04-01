package tz.co.vodacom.bujikun.sportyshoes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping
    public  String createProduct(Model model, @RequestParam(name = "cart") String ids){
        System.out.println(ids);
        return "product/index";    }

    @GetMapping("/stock")
    public String stockIndex(Model model){
        var products = productService.findAll();
        model.addAttribute("products",products);
        return "product/stock";
    }
    @GetMapping(value = {"/view/{id}","/view/{id}/"})
    public String view(@PathVariable("id") Integer id, Model model){
        var product = productService.findById(id);
        model.addAttribute("product",product);
        return "product/view";
    }
}
