package com.stickerdeposu.web.controllers.Admin;

import com.stickerdeposu.web.Service.Concrete.CategoryService;
import com.stickerdeposu.web.models.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    Logger logger = LoggerFactory.getLogger(CategoryController.class);
    @GetMapping("/")
    public String getCategories(@RequestParam(required = false) Integer page, Model model){
        int getPage = Optional.ofNullable(page).orElse(0);
        model.addAttribute("categories",categoryService.findAll(getPage));
        return "/admin/category/index";
    }

    @GetMapping("/create")
    public String createCategory(Model model){
        model.addAttribute("category",new Category());
        return "/admin/category/create";
    }

    @PostMapping("/create")
    public String createCategoryPost(@Valid @ModelAttribute Category category, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("category",category);
            return "/admin/category/create/";
        }
        categoryService.Save(category);
        return "redirect:/admin/category/";
    }

    @GetMapping("update/{id}")
    public String updateCategory(@PathVariable Long id, Model model){
        Category category = categoryService.findById(id);
        model.addAttribute("category",category);
        return "/admin/category/update";
    }

    @PostMapping("update/{id}")
    public String updateCategoryPost(@PathVariable Long id,@Valid @ModelAttribute Category category,BindingResult bindingResult,Model model){

        if (bindingResult.hasErrors()){
            model.addAttribute("category",category);
        }
        Category findedCategory = categoryService.findById(id);
        findedCategory.setCategoryName(category.getCategoryName());
        findedCategory.setDescription(category.getDescription());
        categoryService.Save(findedCategory);
        return "redirect:/admin/category/";
    }

    @GetMapping("delete/{id}")
    public String deleteCategory(@PathVariable Long id){
        categoryService.Delete(categoryService.findById(id));
        return "redirect:/admin/category";
    }
}
