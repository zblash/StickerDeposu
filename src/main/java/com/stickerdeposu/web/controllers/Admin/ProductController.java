package com.stickerdeposu.web.controllers.Admin;

import com.stickerdeposu.web.DTOs.CreateProductDTO;
import com.stickerdeposu.web.Service.Concrete.CategoryService;
import com.stickerdeposu.web.Service.Concrete.ProductService;
import com.stickerdeposu.web.Service.Concrete.StorageService;
import com.stickerdeposu.web.models.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private StorageService storageService;

    @Autowired
    private CategoryService categoryService;

    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @GetMapping("/")
    public String getProducts(Model model){
        model.addAttribute("products",productService.findAll());
        return "/admin/product/index";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product",new Product());
        model.addAttribute("categories", categoryService.findAll());
        return "/admin/product/create";
    }

    @PostMapping("/create")
    public String createPost(@Valid @ModelAttribute("product") Product productDTO, BindingResult bindingResult, Model model){

        if (bindingResult.hasErrors()) {
            model.addAttribute("product", productDTO);
            model.addAttribute("categories", categoryService.findAll());
            return "/admin/product/create";
        }

        productService.Create(productDTO);
        return "redirect:/admin/product/";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model){
        model.addAttribute("product",productService.findById(id));
        model.addAttribute("categories", categoryService.findAll());
        return "/admin/product/update";
    }

    @PostMapping("/update/{id}")
    public String updatePost(@PathVariable Long id,@Valid @ModelAttribute("product") Product productDTO, BindingResult bindingResult, Model model){

        if (bindingResult.hasErrors()) {
            model.addAttribute("product", productDTO);
            model.addAttribute("categories", categoryService.findAll());
            return "/admin/product/update";
        }
        Product product = productService.findById(id);
        productService.Update(product,productDTO);
        return "redirect:/admin/product/";
    }


}
