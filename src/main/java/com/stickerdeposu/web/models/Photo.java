package com.stickerdeposu.web.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "photos")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String directory;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Photo(){}

    public Photo(@NotNull String directory, Product product) {
        this.directory = directory;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
