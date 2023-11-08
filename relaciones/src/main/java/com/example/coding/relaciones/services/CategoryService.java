package com.example.coding.relaciones.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.coding.relaciones.models.Category;
import com.example.coding.relaciones.models.Product;
import com.example.coding.relaciones.repositories.CategoryRepository;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // ... otros métodos del servicio ...

    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> allExcludeCategories(Product product) {
        return categoryRepository.findByProductsNotContains(product);
    }

    public Category findCategoryById(Long id) {
        Optional<Category> check = categoryRepository.findById(id);
        return check.orElse(null);
    }
    public Category findCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }
}

