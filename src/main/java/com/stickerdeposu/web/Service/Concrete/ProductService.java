package com.stickerdeposu.web.Service.Concrete;

import com.stickerdeposu.web.DTOs.CreateProductDTO;
import com.stickerdeposu.web.Repositories.CategoryRepository;
import com.stickerdeposu.web.Repositories.ProductRepository;
import com.stickerdeposu.web.Service.Abstract.IProductService;
import com.stickerdeposu.web.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Product Create(CreateProductDTO productDTO) {
        Product product = new Product();
        product.setProductName(productDTO.getProductName());
        product.setDescription(productDTO.getDescription());
        product.setCategory(categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(RuntimeException::new));
        product.setQuantity(productDTO.getQuantity());

        return productRepository.save(product);
    }

    @Override
    public Product Update(Product product, Product updatedProduct) {
        product.setProductName(updatedProduct.getProductName());
        product.setDescription(updatedProduct.getDescription());
        product.setCategory(updatedProduct.getCategory());
        product.setQuantity(updatedProduct.getQuantity());
        return productRepository.save(product);
    }

    @Override
    public void Delete(Product product) {
        productRepository.delete(product);
    }
}
