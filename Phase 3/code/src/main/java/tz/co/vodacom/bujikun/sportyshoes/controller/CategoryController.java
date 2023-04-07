package tz.co.vodacom.bujikun.sportyshoes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAuthority(T(tz.co.vodacom.bujikun.sportyshoes.enumeration.PermissionName).CATEGORY_VIEW_ALL.value)")
    public String index(Model model){
        model.addAttribute("categories",categoryService.findAll());
        return "category/index";
    }
    @GetMapping(value = {"/add","/add/"})
    @PreAuthorize("hasAuthority(T(tz.co.vodacom.bujikun.sportyshoes.enumeration.PermissionName).CATEGORY_ADD.value)")
    public String getAddCategory(Model model){
       model.addAttribute("category", new Category());
        return "category/add";
    }

    @PostMapping(value = {"/add","/add/"})
    @PreAuthorize("hasAuthority(T(tz.co.vodacom.bujikun.sportyshoes.enumeration.PermissionName).CATEGORY_ADD.value)")
    public String postAddCategory(@ModelAttribute("category") Category category,Model model){
        if( category != null){
            categoryService.createNew(category);
        }
        //TODO pass success message
        return "redirect:/categories";
    }

    @GetMapping("/view/{id}")
    @PreAuthorize("hasAuthority(T(tz.co.vodacom.bujikun.sportyshoes.enumeration.PermissionName).CATEGORY_VIEW.value)")
    public  String getOne(@PathVariable("id") Integer id, Model model){
        var category = categoryService.findActiveById(id);
        model.addAttribute("category",category);
        return "category/view";
    }

    @GetMapping("delete/{id}")
    @PreAuthorize("hasAuthority(T(tz.co.vodacom.bujikun.sportyshoes.enumeration.PermissionName).CATEGORY_DELETE.value)")
    public String delete(@PathVariable("id") Integer id){
        categoryService.delete(id);
        return "redirect:/categories";
    }
    @GetMapping("edit/{id}")
    @PreAuthorize("hasAuthority(T(tz.co.vodacom.bujikun.sportyshoes.enumeration.PermissionName).CATEGORY_EDIT.value)")
    public String getEdit(@PathVariable("id") Integer id, Model model){
        var category = categoryService.findById(id);
        model.addAttribute("category",category);
        return "category/edit";
    }
    @PostMapping("edit")
    @PreAuthorize("hasAuthority(T(tz.co.vodacom.bujikun.sportyshoes.enumeration.PermissionName).CATEGORY_EDIT.value)")
    public String postEdit( @ModelAttribute("category") Category category, Model model){
        categoryService.update(category);
        model.addAttribute("category",category);
        return "redirect:/categories/view/"+category.getId();
    }


    @GetMapping("/{id}/products") //public path
    public String getCategoryProducts(@PathVariable("id")Integer categoryId, Model model){
        var category = categoryService.findActiveById(categoryId);
        var products = category.getProducts()
                .stream()
                .filter(p->p.getCount()>0 && !p.getDeleted())
                .toList();
        model.addAttribute("category",category);
        model.addAttribute("products",products);
        return "category/category-product";
    }

    @GetMapping(value = {"/{id}/link-products","/{id}/link-products/"})
    @PreAuthorize("hasAuthority(T(tz.co.vodacom.bujikun.sportyshoes.enumeration.PermissionName).CATEGORY_LINK_PRODUCT.value)")
    public String getLinkCategoryProducts(@PathVariable("id")Integer categoryId, Model model){
        var category = categoryService.findActiveById(categoryId);
        var categoryProducts = category.getProducts();
        var allProducts = productService.findAll();
        model.addAttribute("category",category);
        model.addAttribute("categoryProducts",categoryProducts);
        model.addAttribute("allProducts",allProducts);
        return "category/link-product";
    }

    @PostMapping(value = {"/link-products","/link-products/"})
    @PreAuthorize("hasAuthority(T(tz.co.vodacom.bujikun.sportyshoes.enumeration.PermissionName).CATEGORY_LINK_PRODUCT.value)")
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
