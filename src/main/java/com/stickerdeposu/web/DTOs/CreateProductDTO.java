package com.stickerdeposu.web.DTOs;

import java.io.File;
import java.util.List;

public class CreateProductDTO {

    private String productName;

    private String description;

    private int quantity;

    private List<File> photos;

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

    public List<File> getPhotos() {
        return photos;
    }

    public void setPhotos(List<File> photos) {
        this.photos = photos;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public CreateProductDTO(String productName, String description, int quantity, List<File> photos, Long categoryId) {
        this.productName = productName;
        this.description = description;
        this.quantity = quantity;
        this.photos = photos;
        this.categoryId = categoryId;
    }
}
