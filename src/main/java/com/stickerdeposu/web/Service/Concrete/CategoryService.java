package com.stickerdeposu.web.Service.Concrete;

import com.stickerdeposu.web.Repositories.CategoryRepository;
import com.stickerdeposu.web.Service.Abstract.ICategoryService;
import com.stickerdeposu.web.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public void Save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void Delete(Category category) {
        categoryRepository.delete(category);
    }
}
