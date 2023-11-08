// En el archivo StudentService.java
package com.example.coding.student.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.stereotype.Service;

import com.example.coding.student.models.Contact;
import com.example.coding.student.models.Student;
import com.example.coding.student.repositories.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void saveStudent(Student newStudent) {
        studentRepository.save(newStudent);
    }

    public Student findDojoById(Long dojoId) {
        java.util.Optional<Student> optionalDojo = studentRepository.findById(dojoId);
        return optionalDojo.orElse(null);
    }

    public List<Student> obtenerStudentConSusContact() {
        List<Student> students = new ArrayList<>();
        List<Object[]> rows = studentRepository.joinStudentsAndContacts2();
        for (Object[] row : rows) {
            Student student = (Student) row[0];
            // Aquí agregamos el student directamente a la lista, ya que solo necesitamos firstName, lastName y age
            students.add(student);
            System.out.println(student.getFirstName());
            System.out.println(student.getLastName());
            System.out.println(student.getAge());
        }

        return students;
    }

    public List<Student> obtenerTodosLosStudents() {
        // TODO Auto-generated method stub
        return null;
    }

    public void saveContact(Contact contact) {
        // TODO Auto-generated method stub

    }

    public List<Student> getAllStudents() {
        // TODO Auto-generated method stub
        return null;
    }

	public static Student findStudentById(Long student) {
		// TODO Auto-generated method stub
		return null;
	}

}

