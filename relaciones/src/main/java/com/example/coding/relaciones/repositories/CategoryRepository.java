package com.example.coding.relaciones.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.coding.relaciones.models.Category;
import com.example.coding.relaciones.models.Product;


@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	List<Category> findAll();
	List<Category> findByProductsNotContains(Product product);
	Category findByName(String name);
}