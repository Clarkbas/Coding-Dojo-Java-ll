package com.example.coding.emyge.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.coding.emyge.models.Empleado;
import com.example.coding.emyge.repositories.EmpleadoRepository;

@Service
public class EmpleadoService {
	// Agregando el book al repositorio como una dependencia
	private final EmpleadoRepository empleadoRepository;

	public EmpleadoService(EmpleadoRepository empleadoRepository) {
		this.empleadoRepository = empleadoRepository;
	}

	// Devolviendo todos los empleados.
	public List<Empleado> allBooks() {
		return empleadoRepository.findAll();
	}
	
	public Empleado findArtist(Long id) {
		Optional<Empleado> optionalBook = empleadoRepository.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	
	}

	// Creando un empleados.
	public Empleado createBook(Empleado b) {
		return empleadoRepository.save(b);
	}

	public EmpleadoRepository getLicenceRepository() {
		return empleadoRepository;
	}

	public void deleteBook(Long id) {
		empleadoRepository.deleteById(id);
		
	}
}
