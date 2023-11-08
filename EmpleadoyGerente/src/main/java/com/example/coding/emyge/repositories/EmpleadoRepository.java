package com.example.coding.emyge.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.coding.emyge.models.Empleado;

public interface EmpleadoRepository extends CrudRepository<Empleado, Long>{

	List<Empleado> findAll();

}
