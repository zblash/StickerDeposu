package com.stickerdeposu.web.Repositories;

import com.stickerdeposu.web.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    Page<Product> findByCategory_Id(Long categoryId, Pageable pageable);


}
