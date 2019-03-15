package com.stickerdeposu.web.Service.Concrete;

import com.stickerdeposu.web.Repositories.CartRepository;
import com.stickerdeposu.web.Service.Abstract.ICartService;
import com.stickerdeposu.web.models.Cart;
import com.stickerdeposu.web.models.CartItem;
import com.stickerdeposu.web.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService implements ICartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public CartItem addCartItem(Cart cart,List<CartItem> cartItems, Product product){
        return cartItems.stream()
                .filter(filteredCartItem -> filteredCartItem.getProduct().getId().equals(product.getId()))
                .peek(mappedCartItem -> {
                    mappedCartItem.setQuantity(mappedCartItem.getQuantity() + 1);
                    mappedCartItem.setTotalPrice(mappedCartItem.getQuantity() * product.getPrice());
                })
                .findFirst()
                .orElseGet(() -> new CartItem(product, cart, product.getPrice(), 1));

    }


    @Override
    public double getTotalPrice(Cart cart){
       return cart.getCartItems().stream().mapToDouble(CartItem::getTotalPrice).sum();
    }


    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public Cart findById(Long id) {
        return cartRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public void Save(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public void Delete(Cart cart) {
        cartRepository.delete(cart);
    }


}
