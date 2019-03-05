package com.stickerdeposu.web.DTOs;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

public class CreateProductDTO {

    private String productName;

    private String description;

    private int quantity;

    private MultipartFile photos[];

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

    public MultipartFile[] getPhotos() {
        return photos;
    }

    public void setPhotos(MultipartFile[] photos) {
        this.photos = photos;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public CreateProductDTO(String productName, String description, int quantity, MultipartFile photos[], Long categoryId) {
        this.productName = productName;
        this.description = description;
        this.quantity = quantity;
        this.photos = photos;
        this.categoryId = categoryId;
    }
}
