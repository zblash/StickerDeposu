package com.stickerdeposu.web.Service.Abstract;

import com.stickerdeposu.web.models.Cart;
import com.stickerdeposu.web.models.CartItem;
import com.stickerdeposu.web.models.Product;

import java.util.List;

public interface ICartService {

    CartItem addCartItem(Cart cart, List<CartItem> cartItems, Product product);

    double getTotalPrice(Cart cart);

    List<Cart> findAll();

    Cart findById(Long id);

    void Save(Cart cart);

    void Delete(Cart cart);
}
