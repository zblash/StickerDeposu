package com.stickerdeposu.web.Service.Abstract;

import com.stickerdeposu.web.models.Category;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ICategoryService {

    Page<Category> findAll(int page);

    Category findById(Long id);

    void Save(Category category);

    void Delete(Category category);

    List<Category> findAllWithoutPage();
}
