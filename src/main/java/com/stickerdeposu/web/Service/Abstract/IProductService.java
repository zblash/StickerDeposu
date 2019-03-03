package com.stickerdeposu.web.Service.Abstract;

import com.stickerdeposu.web.models.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll();

    Product findById(Long id);

    void Save(Product product);

    void Delete(Product product);
}
