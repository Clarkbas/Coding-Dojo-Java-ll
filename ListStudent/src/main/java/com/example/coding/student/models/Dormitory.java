package com.example.coding.student.models;



import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Dormitories")
public class Dormitory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "dormitory", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Student> students;

    public Dormitory() {
        this.students = new ArrayList<>();
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    // Helper method to add a student to the dormitory
    public void addStudent(Student student) {
        this.students.add(student);
        student.setDormitory(this);
    }

    // Helper method to remove a student from the dormitory
    public void removeStudent(Student student) {
        this.students.remove(student);
        student.setDormitory(null);
    }
}
