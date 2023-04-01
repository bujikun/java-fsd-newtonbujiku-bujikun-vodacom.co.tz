package tz.co.vodacom.bujikun.sportyshoes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tz.co.vodacom.bujikun.sportyshoes.dao.ProductCategoryDAO;
import tz.co.vodacom.bujikun.sportyshoes.entity.Category;
import tz.co.vodacom.bujikun.sportyshoes.service.CategoryService;
import tz.co.vodacom.bujikun.sportyshoes.service.ProductService;

@Controller
@RequiredArgsConstructor
@RequestMapping(value={"/categories","/categories/"})
public class CategoryController {
    private final CategoryService categoryService;
    private final ProductService productService;
    private final ProductCategoryDAO productCategoryDAO;
    @GetMapping
    public String index(Model model){
        model.addAttribute("categories",categoryService.findAll());
        return "category/index";
    }
    @GetMapping(value = {"/add","/add/"})
    public String getAddCategory(Model model){
       model.addAttribute("category", new Category());
        return "category/add";
    }

    @PostMapping(value = {"/add","/add/"})
    public String postAddCategory(@ModelAttribute("category") Category category,Model model){
        if( category != null){
            categoryService.createNew(category);
        }
        //TODO pass success message
        return "redirect:/categories";
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
    ///categories/{id}/link-products

    @GetMapping(value = {"/{id}/link-products","/{id}/link-products/"})
    public String getLinkCategoryProducts(@PathVariable("id")Integer categoryId, Model model){
        var category = categoryService.findById(categoryId);
        var categoryProducts = category.getProducts();
        var allProducts = productService.findAll();
        model.addAttribute("category",category);
        model.addAttribute("categoryProducts",categoryProducts);
        model.addAttribute("allProducts",allProducts);
        return "category/link-product";
    }

    @PostMapping(value = {"/link-products","/link-products/"})
    public String postLinkCategoryProducts(@RequestParam(name = "categoryId") Integer categoryId,
                                           @RequestParam(name = "productId") Integer productId,
                                           Model model){
        //TODO could generate exception, handle for error
        productCategoryDAO.linkProductCategory(productId,categoryId);
        var category = categoryService.findById(categoryId);
        var categoryProducts = category.getProducts();
        var allProducts = productService.findAll();
        model.addAttribute("category",category);
        model.addAttribute("categoryProducts",categoryProducts);
        model.addAttribute("allProducts",allProducts);
        return "category/link-product";
    }
}
