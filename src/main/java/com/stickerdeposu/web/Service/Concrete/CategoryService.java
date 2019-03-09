package com.stickerdeposu.web.Service.Concrete;

import com.stickerdeposu.web.Repositories.CategoryRepository;
import com.stickerdeposu.web.Service.Abstract.ICategoryService;
import com.stickerdeposu.web.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Page<Category> findAll(int page) {
        return categoryRepository.findAll(PageRequest.of(page,10));
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

    @Override
    public List<Category> findAllWithoutPage() {
        return categoryRepository.findAll();
    }
}
