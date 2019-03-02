package com.stickerdeposu.web.Repositories;

import com.stickerdeposu.web.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
