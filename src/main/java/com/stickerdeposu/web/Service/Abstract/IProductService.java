package com.stickerdeposu.web.Service.Abstract;

import com.stickerdeposu.web.models.Product;
import org.springframework.data.domain.Page;


public interface IProductService {

    Page<Product> findAll(int page);

    Product findById(Long id);

    Product Create(Product productDTO);

    Product Update(Product product,Product updatedProduct);

    void Delete(Product product);

    Page<Product> findByCategoryId(Long categoryId, int page);
}
