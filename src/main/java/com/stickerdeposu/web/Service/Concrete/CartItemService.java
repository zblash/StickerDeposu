package com.stickerdeposu.web.Service.Concrete;

import com.stickerdeposu.web.Repositories.CartItemRepository;
import com.stickerdeposu.web.Service.Abstract.ICartItemService;
import com.stickerdeposu.web.models.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService implements ICartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;


    @Override
    public List<CartItem> findAll() {
        return cartItemRepository.findAll();
    }

    @Override
    public CartItem findById(Long id) {
        return cartItemRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public void Save(CartItem cartItem) {
        cartItemRepository.save(cartItem);
    }

    @Override
    public void Delete(CartItem cartItem) {
        cartItemRepository.delete(cartItem);
    }
}
