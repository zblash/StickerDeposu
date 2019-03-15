package com.stickerdeposu.web.Interceptor;

import com.stickerdeposu.web.Security.CustomPrincipal;
import com.stickerdeposu.web.models.Cart;
import com.stickerdeposu.web.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Component
public class CartSessionInterceptor implements HandlerInterceptor {

    Logger logger = LoggerFactory.getLogger(CartSessionInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Cart cart;
        if (user != "anonymousUser"){
            cart = ((CustomPrincipal) user).getUser().getCart();
        }else{
            cart = request.getSession().getAttribute("cart") == null ? new Cart()
                    : (Cart)request.getSession().getAttribute("cart");
        }
        request.getSession().setAttribute("cart",cart);
        return true;
    }
}
