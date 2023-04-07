package tz.co.vodacom.bujikun.sportyshoes.controller;

import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FileUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tz.co.vodacom.bujikun.sportyshoes.dao.ProductCategoryDAO;
import tz.co.vodacom.bujikun.sportyshoes.entity.Product;
import tz.co.vodacom.bujikun.sportyshoes.service.CategoryService;
import tz.co.vodacom.bujikun.sportyshoes.service.ProductService;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;
    private final ProductCategoryDAO productCategoryDAO;

    private static String saveUploadedFile(MultipartFile file) {
        String fileName;
        fileName = UUID.randomUUID() + file.getOriginalFilename();
        //write file to system
        var imgPath = FileSystems.getDefault().getPath("").resolve("imgs");
        try {
            Path newFilePath = Files.createFile(imgPath.resolve(fileName));
            FileUtils.copyInputStreamToFile(file.getInputStream(), newFilePath.toFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fileName;
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("products", productService.findAllToPurchase());
        return "product/index";
    }

    @PostMapping
    @PreAuthorize("hasAuthority(T(tz.co.vodacom.bujikun.sportyshoes.enumeration.PermissionName).PRODUCT_ADD.value)")
    public String createProduct(Model model, @RequestParam(name = "cart") String ids) {
        return "product/index";
    }

    @GetMapping("/stock")
    @PreAuthorize("hasAuthority(T(tz.co.vodacom.bujikun.sportyshoes.enumeration.PermissionName).STOCK_VIEW.value)")
    public String stockIndex(Model model) {
        var products = productService.findAll();
        model.addAttribute("products", products);
        return "product/stock";
    }

    @GetMapping(value = {"/view/{id}", "/view/{id}/"})
    @PreAuthorize("hasAuthority(T(tz.co.vodacom.bujikun.sportyshoes.enumeration.PermissionName).PRODUCT_ADD.value)")
    public String view(@PathVariable("id") Integer id, Model model) {
        var product = productService.findById(id);
        model.addAttribute("product", product);
        return "product/view";
    }

    @GetMapping(value = {"/add", "/add/"})
    @PreAuthorize("hasAuthority(T(tz.co.vodacom.bujikun.sportyshoes.enumeration.PermissionName).PRODUCT_ADD.value)")
    public String getAddProduct(Model model) {
        model.addAttribute("product", new Product());
        return "product/add";
    }

    @PostMapping(value = {"/add", "/add/"})
    @PreAuthorize("hasAuthority(T(tz.co.vodacom.bujikun.sportyshoes.enumeration.PermissionName).PRODUCT_ADD.value)")
    public String postAddProduct(@ModelAttribute("product") Product product,
                                 @RequestParam("image") MultipartFile file
    ) {
        String fileName = null;

        if (file != null) {
            fileName = saveUploadedFile(file);
        }
        if (product != null) {
            product.setImageUrl("/imgs/" + fileName);
            productService.createNew(product);
        }
        //TODO pass success message
        return "redirect:/products/stock";
    }

    @GetMapping("edit/{id}")
    @PreAuthorize("hasAuthority(T(tz.co.vodacom.bujikun.sportyshoes.enumeration.PermissionName).PRODUCT_EDIT.value)")
    public String getEdit(@PathVariable("id") Integer id, Model model) {
        var product = productService.findById(id);
        model.addAttribute("product", product);
        return "product/edit";
    }

//    @GetMapping("edit/{id}")
//    @PreAuthorize("hasAuthority(T(tz.co.vodacom.bujikun.sportyshoes.enumeration.PermissionName).PRODUCT_DELETE.value)")
//    public String delete(@PathVariable("id") Integer id, Model model) {
//      productService.delete(id);
//        return "product/index";
//    }

    @PostMapping("edit")
    @PreAuthorize("hasAuthority(T(tz.co.vodacom.bujikun.sportyshoes.enumeration.PermissionName).PRODUCT_EDIT.value)")
    public String postEdit(@ModelAttribute("product") Product product, @RequestParam(required = false,name = "image") MultipartFile file, Model model) {

        String fileName = null;

        if (file != null && !file.isEmpty()) {
            fileName = saveUploadedFile(file);
            product.setImageUrl("/imgs/" + fileName);
        }
        productService.update(product);
        model.addAttribute("product", product);
        return "redirect:/products/view/" + product.getId();
    }

    @GetMapping(value = {"/{id}/link-category", "/{id}/link-category/"})
    @PreAuthorize("hasAuthority(T(tz.co.vodacom.bujikun.sportyshoes.enumeration.PermissionName).PRODUCT_LINK_CATEGORY.value)")
    public String getLinkProductCategories(@PathVariable("id") Integer productId, Model model) {
        var product = productService.findById(productId);
        var productCategories = product.getCategories();
        var allCategories = categoryService.findAll();
        model.addAttribute("product", product);
        model.addAttribute("productCategories", productCategories);
        model.addAttribute("allCategories", allCategories);
        return "product/link-category";
    }

    @PostMapping(value = {"/link-category", "/link-category/"})
    @PreAuthorize("hasAuthority(T(tz.co.vodacom.bujikun.sportyshoes.enumeration.PermissionName).PRODUCT_LINK_CATEGORY.value)")
    public String postLinkCategoryProducts(@RequestParam(name = "categoryId") Integer categoryId,
                                           @RequestParam(name = "productId") Integer productId,
                                           Model model) {
        //TODO could generate exception, handle for error
        productCategoryDAO.linkProductCategory(productId, categoryId);
        var product = productService.findById(productId);
        var productCategories = product.getCategories();
        var allCategories = categoryService.findAll();
        model.addAttribute("product", product);
        model.addAttribute("productCategories", productCategories);
        model.addAttribute("allCategories", allCategories);
        return "product/link-category";
    }
}
