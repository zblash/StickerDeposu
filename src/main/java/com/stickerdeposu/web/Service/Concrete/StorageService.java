package com.stickerdeposu.web.Service.Concrete;

import com.stickerdeposu.web.Service.Abstract.IStorageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Service
public class StorageService implements IStorageService {

    @Value("${upload.path}")
    private String abspath;


    @Override
    public void store(MultipartFile file) {
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(abspath, file.getOriginalFilename());
            Files.write(path, bytes);
        }catch (IOException e){
            throw new RuntimeException();
        }
    }

    @Override
    public Stream<Path> loadAll() {
        return null;
    }

    @Override
    public Path load(String filename) {
        return null;
    }

    @Override
    public Resource loadAsResource(String filename) {
        return null;
    }

    @Override
    public void deleteAll() {

    }
}
