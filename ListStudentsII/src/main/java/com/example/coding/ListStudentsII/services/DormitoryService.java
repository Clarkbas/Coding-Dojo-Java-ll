package com.example.coding.ListStudentsII.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.coding.ListStudentsII.models.Dormitory;
import com.example.coding.ListStudentsII.repositories.DormitoryRepository;

@Service
public class DormitoryService {
	private final DormitoryRepository dormitoryRepository;

    public DormitoryService(DormitoryRepository dormitoryRepository) {
        this.dormitoryRepository = dormitoryRepository;
    }
 
    public List<Dormitory> all() {
        return dormitoryRepository.findAll();
    }
    
    public Dormitory createDormitory(Dormitory d) {
        return dormitoryRepository.save(d);
    }
    
    public Dormitory findDormitory(Long id) {
        Optional<Dormitory> optionalDorm = dormitoryRepository.findById(id);
        if(optionalDorm.isPresent()) {
            return optionalDorm.get();
        } else {
            return null;
        }
    }
    
    public Dormitory updateDormitory(Long id, String name, List<Dormitory> dormitorys) {    	
    	Dormitory CI = new Dormitory (name);
        return dormitoryRepository.save(CI);
    }
    
    public List<Dormitory> nullDormitory() {
        return dormitoryRepository.findByStudentsIsNull();
    }
    
    public void create4Dormitory(Dormitory s) {
		Dormitory dormitory1 = new Dormitory(s.getName());
	    Dormitory dormitory2 = new Dormitory(s.getName());
	    Dormitory dormitory3 = new Dormitory(s.getName());
	    Dormitory dormitory4 = new Dormitory(s.getName());

	    dormitoryRepository.save(dormitory1);
	    dormitoryRepository.save(dormitory2);
	    dormitoryRepository.save(dormitory3);
		
	}
  

    public void deleteDormitory (Long id) {
        Optional<Dormitory> dorm = dormitoryRepository.findById(id);
        if(dorm.isPresent()) {
        	dormitoryRepository.deleteById(id);
        } 
    }
}