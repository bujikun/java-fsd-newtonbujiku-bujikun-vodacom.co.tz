package tz.co.vodacom.bujikun.sportyshoes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tz.co.vodacom.bujikun.sportyshoes.entity.Category;
import tz.co.vodacom.bujikun.sportyshoes.service.CategoryService;

@Controller
@RequiredArgsConstructor
@RequestMapping(value={"/categories","/categories/"})
public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping
    public String index(Model model){
        model.addAttribute("categories",categoryService.findAll());
        return "category/index";
    }

    @GetMapping("/{id}")
    public  String getOne(@PathVariable("id") Integer id, Model model){
        var category = categoryService.findById(id);
        model.addAttribute("category",category);
        return "category/view";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        categoryService.delete(id);
        return "redirect:/categories";
    }
    @GetMapping("edit/{id}")
    public String getEdit(@PathVariable("id") Integer id, Model model){
        var category = categoryService.findById(id);
        model.addAttribute("category",category);
        return "category/edit";
    }
    @PostMapping("edit")
    public String postEdit( @ModelAttribute("category") Category category, Model model){
        categoryService.update(category);
        model.addAttribute("category",category);
        return "redirect:/categories/"+category.getId();
    }


    @GetMapping("/{id}/products")
    public String getCategoryProducts(@PathVariable("id")Integer categoryId, Model model){
        var category = categoryService.findById(categoryId);
        var products = category.getProducts();
        model.addAttribute("category",category);
        model.addAttribute("products",products);
        return "category/category-product";
    }
}
