package com.stickerdeposu.web.Repositories;

import com.stickerdeposu.web.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
