package com.stickerdeposu.web.Service.Abstract;

import com.stickerdeposu.web.DTOs.CreateProductDTO;
import com.stickerdeposu.web.models.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll();

    Product findById(Long id);

    Product Create(Product productDTO);

    Product Update(Product product,Product updatedProduct);

    void Delete(Product product);
}
