package tz.co.vodacom.bujikun.sportyshoes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import tz.co.vodacom.bujikun.sportyshoes.service.CategoryService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/{id}/products")
    public String getCategoryProducts(@PathVariable("id")Integer categoryId, Model model){
        var category = categoryService.findById(categoryId);
        var products = category.getProducts();
        model.addAttribute("category",category);
        model.addAttribute("products",products);
        return "category/category-product";
    }
}
