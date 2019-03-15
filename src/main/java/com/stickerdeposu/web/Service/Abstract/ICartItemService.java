package com.stickerdeposu.web.Service.Abstract;

import com.stickerdeposu.web.models.Cart;
import com.stickerdeposu.web.models.CartItem;
import com.stickerdeposu.web.models.Product;

import java.util.List;

public interface ICartItemService {

    List<CartItem> findAll();

    CartItem findById(Long id);

    void Save(CartItem cartItem);

    void Delete(CartItem cartItem);

    int sumQuantity(List<CartItem> cartItems);
}
