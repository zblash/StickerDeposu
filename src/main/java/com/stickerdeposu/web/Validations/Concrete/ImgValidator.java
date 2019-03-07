package com.stickerdeposu.web.Validations.Concrete;

import com.stickerdeposu.web.Validations.Abstract.ValidImg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class ImgValidator implements ConstraintValidator<ValidImg, MultipartFile[]> {

    @Override
    public void initialize(ValidImg constraintAnnotation) {

    }

    @Override
    public boolean isValid(MultipartFile multipartFiles[], ConstraintValidatorContext context) {

        boolean result = true;
        for (MultipartFile multipartFile : multipartFiles){
            if (!isSupportedContentType(multipartFile.getContentType())){
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(
                        "Sadece Image tipi dosyalar yükleyebilirsiniz.")
                        .addConstraintViolation();
                result = false;
                break;
            }
        }
        return result;
    }

    private boolean isSupportedContentType(String contentType) {
        return contentType.equals("image/png")
                || contentType.equals("image/jpg")
                || contentType.equals("image/jpeg");
    }
}