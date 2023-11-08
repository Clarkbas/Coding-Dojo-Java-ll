package com.example.coding.ListStudentsII.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.coding.ListStudentsII.models.Dormitory;

@Repository
public interface DormitoryRepository extends CrudRepository<Dormitory, Long>{

	List<Dormitory> findAll();
    
	Optional<Dormitory> findById(Long id);
	
	//GET NULL CONTACT; 
	List<Dormitory> findByStudentsIsNull();
}