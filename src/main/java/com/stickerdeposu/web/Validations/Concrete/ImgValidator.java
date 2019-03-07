package com.stickerdeposu.web.Validations.Concrete;

import com.stickerdeposu.web.Validations.Abstract.ValidImg;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ImgValidator implements ConstraintValidator<ValidImg, MultipartFile> {

    @Override
    public void initialize(ValidImg constraintAnnotation) {

    }


    @Override
    public boolean isValid(MultipartFile multipartFile, ConstraintValidatorContext context) {

        if (isSupportedContentType(multipartFile.getContentType())) return true;
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(
                "Sadece Image tipi dosyalar yükleyebilirsiniz.")
                .addConstraintViolation();
        return false;
    }

    private boolean isSupportedContentType(String contentType) {
        return contentType.equals("image/png")
                || contentType.equals("image/jpg")
                || contentType.equals("image/jpeg");
    }
}