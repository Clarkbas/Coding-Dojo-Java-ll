package com.example.coding.student.services;

import com.example.coding.student.models.Dormitory;

import java.util.List;

public interface DormitoryService {
    Dormitory findDormitoryById(Long id);
    List<Dormitory> getAllDormitories();
    void saveDormitory(Dormitory dormitory);
    // Otros métodos 
}

