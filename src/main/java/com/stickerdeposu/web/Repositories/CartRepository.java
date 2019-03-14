package com.stickerdeposu.web.Repositories;

import com.stickerdeposu.web.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart,Long> {


}
