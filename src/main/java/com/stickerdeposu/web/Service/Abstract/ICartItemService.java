package com.stickerdeposu.web.Service.Abstract;

import com.stickerdeposu.web.models.CartItem;

import java.util.List;

public interface ICartItemService {

    List<CartItem> findAll();

    CartItem findById(Long id);

    void Save(CartItem cartItem);

    void Delete(CartItem cartItem);
}
