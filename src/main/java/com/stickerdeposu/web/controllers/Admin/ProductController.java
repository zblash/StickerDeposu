package com.stickerdeposu.web.controllers.Admin;

import com.stickerdeposu.web.DTOs.CreateProductDTO;
import com.stickerdeposu.web.Service.Concrete.CategoryService;
import com.stickerdeposu.web.Service.Concrete.ProductService;
import com.stickerdeposu.web.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product",new CreateProductDTO());
        model.addAttribute("categories", categoryService.findAll());
        return "/admin/product/create";
    }


}
