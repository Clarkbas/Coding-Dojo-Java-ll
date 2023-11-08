package com.codingdojo.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.License;
import com.codingdojo.mvc.repositories.LicenseRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Service
@PersistenceContext
public class LicenseService {
	//Agregando el license al repositorio como una dependencia
	private final LicenseRepository licenseRepository;
	
    @Autowired
    public LicenseService(LicenseRepository licenseRepository, EntityManager entityManager) {
        this.licenseRepository = licenseRepository;
        this.entityManager = entityManager;
    }

	public LicenseService(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}
	
	public List<License> findAll() {
		return licenseRepository.findAll();
	}
	
	public License saveLicense(License license) {
		return licenseRepository.save(license);
	}
	
	public License findLicense(Long id) {
		Optional<License> optionalLicense = licenseRepository.findById(id);
		if(optionalLicense.isPresent()) {
			return optionalLicense.get();
		} else {
			return null;
		}
	}
	
	public License updateLicense(License license) {
		return licenseRepository.save(license);
	}
	
	public void deleteLicense(Long id) {
		licenseRepository.deleteById(id);
	}

    public License findLicenseByPersonId(Long personId) {
        Optional<License> optionalLicense = licenseRepository.findByPersonId(personId);
        return optionalLicense.orElse(null);
    }
    private EntityManager entityManager;
    

    public License findLastLicense() {
        // Consultar la base de datos para obtener la última licencia por orden descendente del número de licencia
        TypedQuery<License> query = entityManager.createQuery(
                "SELECT l FROM License l WHERE l.number IS NOT NULL ORDER BY l.number DESC", License.class);
        query.setMaxResults(1); // Obtener solo el primer resultado (la última licencia)
        List<License> results = query.getResultList();

        if (results.isEmpty()) {
            return null; // No se encontraron licencias, la base de datos está vacía
        } else {
            return results.get(0); // Devolver la última licencia encontrada
        }
    }
}
