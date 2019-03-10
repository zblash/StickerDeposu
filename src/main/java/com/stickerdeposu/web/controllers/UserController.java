package com.stickerdeposu.web.controllers;

import com.stickerdeposu.web.Service.Concrete.RoleService;
import com.stickerdeposu.web.Service.Concrete.UserService;
import com.stickerdeposu.web.models.Role;
import com.stickerdeposu.web.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    Logger logger = LoggerFactory.getLogger(UserController.class);
    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerPost(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {

        if (result.hasErrors()){
            model.addAttribute("user", user);
            return "register";
        }
        user.addRole(roleService.findByName("ROLE_USER"));
        userService.Save(user);
        return "redirect:/login";

    }

    @RequestMapping("/login")
    public String loginPage(){
        return "login";
    }
}