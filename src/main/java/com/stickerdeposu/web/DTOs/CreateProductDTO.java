package com.stickerdeposu.web.DTOs;

import com.stickerdeposu.web.Validations.Abstract.ValidImg;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class CreateProductDTO {

    @NotNull(message = "Boş Geçilemez")
    private String productName;

    @NotNull(message = "Boş Geçilemez")
    private String description;

    @NotNull(message = "Boş Geçilemez")
    private int quantity;

    @ValidImg
    private List<MultipartFile> photos;

    private Long categoryId;

    public CreateProductDTO() {
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public CreateProductDTO(String productName, String description, int quantity, List<MultipartFile> photo, Long categoryId) {
        this.productName = productName;
        this.description = description;
        this.quantity = quantity;
        this.photos = photos;
        this.categoryId = categoryId;
    }
}
