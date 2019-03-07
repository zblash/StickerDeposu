package com.stickerdeposu.web.Service.Concrete;

import com.stickerdeposu.web.Repositories.PhotoRepository;
import com.stickerdeposu.web.Service.Abstract.IPhotoService;
import com.stickerdeposu.web.models.Photo;
import com.stickerdeposu.web.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PhotoService implements IPhotoService {

    @Autowired
    private PhotoRepository photoRepository;

    @Override
    public List<Photo> findAll() {
        return photoRepository.findAll();
    }

    @Override
    public Photo findById(Long id) {
        return photoRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public void Save(Photo photo) {
        photoRepository.save(photo);
    }

    @Override
    public void Create(List<String> names, Product product){
        names.forEach(fileName -> {
            Photo photo = new Photo();
            photo.setDirectory(fileName);
            photo.setProduct(product);
            photoRepository.save(photo);
        });
    }

    @Override
    public void Delete(Photo photo) {
        photoRepository.delete(photo);
    }
}
