package com.stickerdeposu.web.controllers.Admin;

import com.stickerdeposu.web.Service.Concrete.PhotoService;
import com.stickerdeposu.web.Service.Concrete.StorageService;
import com.stickerdeposu.web.Validations.Abstract.ValidImg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class PhotoController {

    @Autowired
    private StorageService storageService;

    @Autowired
    private PhotoService photoService;

    @Validated
    @PostMapping("/photo/add")
    @ResponseBody
    public ResponseEntity<?> uploadPhoto(@ValidImg @RequestParam("photo") MultipartFile uploadfile){
        String fileName = storageService.store(uploadfile);
        photoService.Create(fileName);
        return new ResponseEntity<>(fileName, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/photos")
    @ResponseBody
    public ResponseEntity<?> getPhotos(){
        return new ResponseEntity<>(photoService.findAll(), new HttpHeaders(), HttpStatus.OK);
    }

}
