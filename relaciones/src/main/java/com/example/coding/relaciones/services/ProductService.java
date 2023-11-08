package com.example.coding.relaciones.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.coding.relaciones.models.Category;
import com.example.coding.relaciones.models.CategoryProduct;
import com.example.coding.relaciones.models.Product;
import com.example.coding.relaciones.repositories.CategoryRepository;
import com.example.coding.relaciones.repositories.ProductRepository;
import com.example.coding.relaciones.repositories.CategoryProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // ... otros métodos del servicio ...

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product findProductById(Long id) {
        Optional<Product> check = productRepository.findById(id);
        return check.orElse(null);
    }
    public List<Product> allExcludeProducts(Category category) {
        return productRepository.findByCategoriesNotContains(category);
    }
    public Product findProductByName(String name) {
        return productRepository.findByName(name);
    }
}



