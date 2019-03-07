package com.stickerdeposu.web.controllers.Admin;

import com.stickerdeposu.web.DTOs.CreateProductDTO;
import com.stickerdeposu.web.Service.Concrete.CategoryService;
import com.stickerdeposu.web.Service.Concrete.PhotoService;
import com.stickerdeposu.web.Service.Concrete.ProductService;
import com.stickerdeposu.web.Service.Concrete.StorageService;
import com.stickerdeposu.web.models.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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

    @Autowired
    private PhotoService photoService;

    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @GetMapping("/")
    public String getProducts(Model model){
        model.addAttribute("products",productService.findAll());
        return "/admin/product/index";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product",new CreateProductDTO());
        model.addAttribute("categories", categoryService.findAll());
        return "/admin/product/create";
    }

    @PostMapping("/create")
    public String createPost(@Valid @ModelAttribute("product") CreateProductDTO productDTO, BindingResult bindingResult, Model model){

        if (bindingResult.hasErrors()) {
            model.addAttribute("product", productDTO);
            model.addAttribute("categories", categoryService.findAll());
            return "/admin/product/create";
        }
        List<String> store = storageService.store(productDTO.getPhotos());
        Product create = productService.Create(productDTO);
        photoService.Create(store,create);
        return "redirect:/admin/product/";
    }



}
