package com.stickerdeposu.web.Service.Abstract;

import com.stickerdeposu.web.models.Cart;

import java.util.List;

public interface ICartService {

    List<Cart> findAll();

    Cart findById(Long id);

    void Save(Cart cart);

    void Delete(Cart cart);
}
