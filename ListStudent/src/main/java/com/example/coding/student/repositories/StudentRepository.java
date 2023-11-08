package com.example.coding.student.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.coding.student.models.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
    List<Student> findAll();
    Optional<Student> findById(Long id);
    
    // obtener todos los dojos
    @Query("SELECT d FROM Student d")
    List<Student> findAllStudents();
    
    // obtener todos los nombre de los dojos.
    @Query("SELECT d.firstName From Student d")
    List<String> findAllStudentsNames();
    
    // Pasar parámetros y filtrar (todavía devuelve una lista)
    @Query("SELECT d FROM Student d WHERE id = ?1")
    List<Student> getStudentWhereId(Long id);
    
    // Pasando parámetros y filtrando.
    @Query("SELECT d FROM Student d WHERE id = ?1")
    Student getSingleStudentWhereId(Long id);
    
 // Observe el tipo int.  
//    Es porque esta función devuelve el número de filas involucradas en la modificación.
    @Modifying
    @Query("update Student d set d.firstName = ?1 WHERE d.id = ?2")
    int setNameForOne(String firstName, Long id);
    
    @Modifying
    @Query("update Student d set d.firstName = ?1")
    int setNameForAll(String firstName);
    
    @Modifying
    @Query("delete Student d WHERE d.id = ?1")
    int deleteOneStudent(Long id);
    
    // Seleccionar todo. Obtenemos una lista de objetos Student.
    @Query(value="SELECT * from student", nativeQuery=true)
    List<Student> findAllDojosWithNativeQuery();
    
    // Obtener todos los nombres y el id de los student. Si queremos seleccionar una columna específica, obtenemos     una arreglo de objetos porque ya no son objetos Dojos. Cada índice del arreglo será la columna seleccionada      respectivamente, por lo tanto, 0 = columna id, 1 = columna nombre.
    @Query(value="SELECT id, firstName from student", nativeQuery=true)
    List<Object[]> findAllStudentsNamesWithId2();
    
    // Obtener un dojo.
    @Query(value="SELECT * FROM student WHERE id = ?1", nativeQuery=true)
    Student getStudentWhereId_v2(Long id);
    
    // inner join para obtener solo los student
    @Query("SELECT d FROM Student d JOIN d.contact n")
    List<Student> joinStudentsAndNinjas();
    
    // inner join para obtener los students y los Contacts
    @Query("SELECT d, n FROM Student d JOIN d.contact n")
	List<Object[]> joinStudentsAndContacts2();
    


}
