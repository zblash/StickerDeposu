package com.stickerdeposu.web.Service.Abstract;

import com.stickerdeposu.web.models.Photo;
import com.stickerdeposu.web.models.Product;

import java.util.List;

public interface IPhotoService {

    List<Photo> findAll();

    Photo findById(Long id);

    void Save(Photo photo);

    void Create(List<String> names, Product product);

    void Delete(Photo photo);
}
