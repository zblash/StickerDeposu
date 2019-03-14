package com.stickerdeposu.web.controllers;

import com.stickerdeposu.web.Repositories.CartItemRepository;
import com.stickerdeposu.web.Repositories.CartRepository;
import com.stickerdeposu.web.Security.CustomPrincipal;
import com.stickerdeposu.web.Service.Concrete.ProductService;
import com.stickerdeposu.web.models.Cart;
import com.stickerdeposu.web.models.CartItem;
import com.stickerdeposu.web.models.Product;
import com.stickerdeposu.web.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private CartRepository cartRepository;

    Logger logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/magaza")
    public String homePage(Model model){
        Page<Product> products = productService.findAll(0);
        model.addAttribute("products",products);
        return "store";
    }

    @GetMapping("/add-to-cart/{productId}")
    public String addToCart(@PathVariable Long productId, Authentication authentication)
    {
        User activeUser = ((CustomPrincipal) authentication.getPrincipal()).getUser();
        Cart cart = cartRepository.findById(activeUser.getCart().getId()).orElseThrow(RuntimeException::new);
        List<CartItem> cartItems = cart.getCartItems();
        Product product = productService.findById(productId);

        CartItem cartItem = cartItems.stream()
                .filter(filteredCartItem -> filteredCartItem.getProduct().getId().equals(product.getId()))
                .peek(mappedCartItem -> {
                    mappedCartItem.setQuantity(mappedCartItem.getQuantity()+1);
                    mappedCartItem.setTotalPrice(mappedCartItem.getQuantity()*product.getPrice());
                })
                .findFirst()
                .orElseGet(() -> new CartItem(product,cart,product.getPrice(),1));

        cartItemRepository.save(cartItem);
        return "redirect:/magaza";
    }

}
