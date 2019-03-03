package com.stickerdeposu.web.Service.Abstract;

import com.stickerdeposu.web.models.Photo;

import java.util.List;

public interface IPhotoService {

    List<Photo> findAll();

    Photo findById(Long id);

    void Save(Photo photo);

    void Delete(Photo photo);
}
