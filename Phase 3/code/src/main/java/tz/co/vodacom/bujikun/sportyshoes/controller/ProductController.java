package tz.co.vodacom.bujikun.sportyshoes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tz.co.vodacom.bujikun.sportyshoes.dao.ProductCategoryDAO;
import tz.co.vodacom.bujikun.sportyshoes.service.CategoryService;
import tz.co.vodacom.bujikun.sportyshoes.service.ProductService;

import java.util.stream.Collectors;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;
    private final ProductCategoryDAO productCategoryDAO;

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

    @GetMapping(value = {"/{id}/link-category","/{id}/link-category/"})
    public String getLinkProductCategories(@PathVariable("id")Integer productId, Model model){
        var product = productService.findById(productId);
        var productCategories = product.getCategories();
        var allCategories = categoryService.findAll();
        model.addAttribute("product",product);
        model.addAttribute("productCategories",productCategories);
        model.addAttribute("allCategories",allCategories);
        return "product/link-category";
    }

    @PostMapping(value = {"/link-category","/link-category/"})
    public String postLinkCategoryProducts(@RequestParam(name = "categoryId") Integer categoryId,
                                           @RequestParam(name = "productId") Integer productId,
                                           Model model){
        //TODO could generate exception, handle for error
        productCategoryDAO.linkProductCategory(productId,categoryId);
        var product = productService.findById(productId);
        var productCategories = product.getCategories();
        var allCategories = categoryService.findAll();
        model.addAttribute("product",product);
        model.addAttribute("productCategories",productCategories);
        model.addAttribute("allCategories",allCategories);
        return "product/link-category";
    }
}
