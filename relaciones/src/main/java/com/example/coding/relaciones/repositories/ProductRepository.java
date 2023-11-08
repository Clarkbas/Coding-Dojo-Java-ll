package com.example.coding.relaciones.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.coding.relaciones.models.Category;
import com.example.coding.relaciones.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	
	List<Product> findByCategoriesNotContains(Category category);
	Product findByName(String name);
}
