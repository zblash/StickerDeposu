package com.stickerdeposu.web.controllers.Admin;

import com.stickerdeposu.web.DTOs.CreateProductDTO;
import com.stickerdeposu.web.Service.Concrete.CategoryService;
import com.stickerdeposu.web.Service.Concrete.ProductService;
import com.stickerdeposu.web.models.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Controller
@RequestMapping("/admin/product")
public class ProductController {

    @Value("${upload.path}")
    private String pathu;


    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product",new CreateProductDTO());
        model.addAttribute("categories", categoryService.findAll());
        return "/admin/product/create";
    }

    @PostMapping("/create")
    public String createPost(@ModelAttribute CreateProductDTO productDTO, Model model){
        model.addAttribute("product",productDTO);
        for (MultipartFile file : productDTO.getPhotos()){
            logger.info(file.getOriginalFilename());
            try {
                byte[] bytes = file.getBytes();
                Path path = Paths.get("C://cmder_mini/" + file.getOriginalFilename());
                logger.info(path.toString());
                Files.write(path, bytes);
            }catch (IOException e){

            }
        }

        return "/admin/product/create";
    }

}
