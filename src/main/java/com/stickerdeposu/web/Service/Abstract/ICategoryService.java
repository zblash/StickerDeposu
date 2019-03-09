package com.stickerdeposu.web.Service.Abstract;

import com.stickerdeposu.web.models.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> findAll(int page);

    Category findById(Long id);

    void Save(Category category);

    void Delete(Category category);

    List<Category> findAllWithoutPage();
}
