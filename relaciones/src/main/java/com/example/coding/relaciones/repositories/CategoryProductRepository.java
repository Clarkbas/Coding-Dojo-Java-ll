package com.example.coding.relaciones.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.coding.relaciones.models.Category;
import com.example.coding.relaciones.models.CategoryProduct;
import com.example.coding.relaciones.models.Product;

@Repository
public interface CategoryProductRepository extends CrudRepository<CategoryProduct, Long> {

}
