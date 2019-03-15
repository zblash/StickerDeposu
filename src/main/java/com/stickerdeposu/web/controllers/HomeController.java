package com.stickerdeposu.web.controllers;

import com.stickerdeposu.web.Security.CustomPrincipal;
import com.stickerdeposu.web.Service.Concrete.CartItemService;
import com.stickerdeposu.web.Service.Concrete.CartService;
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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    @Autowired
    private CartItemService cartItemService;


    Logger logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/magaza")
    public String homePage(Model model){
        Page<Product> products = productService.findAll(0);
        model.addAttribute("products",products);
        return "store";
    }

    @GetMapping("/add-to-cart/{productId}")
    public String addToCart(@PathVariable Long productId, Authentication authentication, HttpSession session)
    {
        Product product = productService.findById(productId);
        Cart cart;
        List<CartItem> cartItems;
        CartItem cartItem;
        Optional<Authentication> auth = Optional.ofNullable(authentication);
        if (auth.isPresent()){
            cart = ((CustomPrincipal) authentication.getPrincipal()).getUser().getCart();
            cartItems = cart.getCartItems();
            cartItem = cartService.addCartItem(cart,cartItems,product);
            cartItemService.Save(cartItem);
            cart.setTotalPrice(cartService.getTotalPrice(cart));
            cartService.Save(cart);
        }else{
            cart = session.getAttribute("cart") == null ? new Cart()
                    : (Cart)session.getAttribute("cart");
            cartItems = cart.getCartItems();
            cartItem = cartService.addCartItem(cart,cartItems,product);
            if (!cart.getCartItems().contains(cartItem)) cart.addItem(cartItem);
            cart.setTotalPrice(cartService.getTotalPrice(cart));
        }
        session.setAttribute("cart",cart);
        session.setAttribute("cartItemsQuantity",cartItemService.sumQuantity(cartItems));
        return "redirect:/magaza";
    }
    @GetMapping("/sepetim")
    public String cartPage(Model model,Authentication authentication, HttpSession session){
        Optional<Authentication> auth = Optional.ofNullable(authentication);
        Cart cart;
        if (auth.isPresent()){
            cart = ((CustomPrincipal) authentication.getPrincipal()).getUser().getCart();
        }else{
            cart = session.getAttribute("cart") == null ? new Cart()
                    : (Cart)session.getAttribute("cart");
        }
        model.addAttribute("cart",cart);
        return "cart";
    }
}
