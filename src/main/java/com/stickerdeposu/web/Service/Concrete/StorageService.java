package com.stickerdeposu.web.Service.Concrete;

import com.stickerdeposu.web.Service.Abstract.IStorageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Service
public class StorageService implements IStorageService {

    private final Path rootLocation = Paths.get("upload-dir");

    @Override
    public List<String> store(MultipartFile files[]) {
            List<String> fileNames = new ArrayList<>();
            Arrays.stream(files).forEach(file -> {
                try {
                String fileName = StringUtils.cleanPath(file.getOriginalFilename());
                fileName = fileName.toLowerCase().replaceAll(" ", "-");
                fileNames.add(fileName);
                Files.copy(file.getInputStream(), this.rootLocation.resolve(fileName));
                }catch (IOException e){
                    throw new RuntimeException();
                }
            });

            return fileNames;
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
        try {
            Path file = rootLocation.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("FAIL!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("FAIL!");
        }
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void init() {
        if (!Files.exists(rootLocation))
        {
            try {
                Files.createDirectory(rootLocation);
            } catch (IOException e) {
                throw new RuntimeException("Could not initialize storage!");
            }
        }
    }
}
