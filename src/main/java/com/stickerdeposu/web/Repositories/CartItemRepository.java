package com.stickerdeposu.web.Repositories;

import com.stickerdeposu.web.models.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {
}
