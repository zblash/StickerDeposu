package com.stickerdeposu.web.Service.Abstract;

import com.stickerdeposu.web.DTOs.CreateProductDTO;
import com.stickerdeposu.web.models.Product;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {

    List<Product> findAll(int page);

    Product findById(Long id);

    Product Create(Product productDTO);

    Product Update(Product product,Product updatedProduct);

    void Delete(Product product);

    List<Product> findByCategoryId(Long categoryId, int page);
}
