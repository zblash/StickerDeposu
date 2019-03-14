package com.stickerdeposu.web.Service.Concrete;

import com.stickerdeposu.web.Repositories.CategoryRepository;
import com.stickerdeposu.web.Repositories.ProductRepository;
import com.stickerdeposu.web.Service.Abstract.IProductService;
import com.stickerdeposu.web.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Page<Product> findAll(int page) {

       return productRepository.findAll(PageRequest.of(page,10));
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Page<Product> findByCategoryId(Long categoryId, int page) {
        return productRepository.findByCategory_Id(categoryId, PageRequest.of(page,10));
    }

    @Override
    public Product Create(Product productDTO) {
        productDTO.setCategory(categoryRepository.findById(Long.valueOf(productDTO.getCategoryId())).orElseThrow(RuntimeException::new));
        return productRepository.save(productDTO);
    }

    @Override
    public Product Update(Product product, Product updatedProduct) {
        product.setProductName(updatedProduct.getProductName());
        product.setDescription(updatedProduct.getDescription());
        product.setCategory(categoryRepository.findById(Long.valueOf(updatedProduct.getCategoryId())).orElseThrow(RuntimeException::new));
        product.setQuantity(updatedProduct.getQuantity());
        product.setPhoto(updatedProduct.getPhoto());
        return productRepository.save(product);
    }

    @Override
    public void Delete(Product product) {
        productRepository.delete(product);
    }


}
