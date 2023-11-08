package com.example.coding.relaciones.services;

import org.springframework.stereotype.Service;

import com.example.coding.relaciones.models.CategoryProduct;
import com.example.coding.relaciones.repositories.CategoryProductRepository;

@Service
public class CategoryProductService {

    private final CategoryProductRepository categoryProductRepository;

    public CategoryProductService(CategoryProductRepository categoryProductRepository) {
        this.categoryProductRepository = categoryProductRepository;
    }

    public CategoryProduct joinCategoryToProduct(CategoryProduct categoryProduct) {
        return categoryProductRepository.save(categoryProduct);
    }

    // Otros métodos relacionados con la relación entre categorías y productos (si los hay)
}

