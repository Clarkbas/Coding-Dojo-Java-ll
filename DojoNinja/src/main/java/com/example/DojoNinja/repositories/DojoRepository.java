package com.example.DojoNinja.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.DojoNinja.models.Dojo;

@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long> {
    List<Dojo> findAll();
    Optional<Dojo> findById(Long id);
    
    // obtener todos los dojos
    @Query("SELECT d FROM Dojo d")
    List<Dojo> findAllDojos();
    
    // obtener todos los nombre de los dojos.
    @Query("SELECT d.name From Dojo d")
    List<String> findAllDojosNames();
    
    // Pasar parámetros y filtrar (todavía devuelve una lista)
    @Query("SELECT d FROM Dojo d WHERE id = ?1")
    List<Dojo> getDojoWhereId(Long id);
    
    // Pasando parámetros y filtrando.
    @Query("SELECT d FROM Dojo d WHERE id = ?1")
    Dojo getSingleDojoWhereId(Long id);
    
 // Observe el tipo int.  
//    Es porque esta función devuelve el número de filas involucradas en la modificación.
    @Modifying
    @Query("update Dojo d set d.name = ?1 WHERE d.id = ?2")
    int setNameForOne(String name, Long id);
    
    @Modifying
    @Query("update Dojo d set d.name = ?1")
    int setNameForAll(String name);
    
    @Modifying
    @Query("delete Dojo d WHERE d.id = ?1")
    int deleteOneDojo(Long id);
    
    // Seleccionar todo. Obtenemos una lista de objetos Dojo.
    @Query(value="SELECT * from dojos", nativeQuery=true)
    List<Dojo> findAllDojosWithNativeQuery();
    
    // Obtener todos los nombres y el id de los dojos. Si queremos seleccionar una columna específica, obtenemos     una arreglo de objetos porque ya no son objetos Dojos. Cada índice del arreglo será la columna seleccionada      respectivamente, por lo tanto, 0 = columna id, 1 = columna nombre.
    @Query(value="SELECT id, name from dojos", nativeQuery=true)
    List<Object[]> findAllDojosNamesWithId2();
    
    // Obtener un dojo.
    @Query(value="SELECT * FROM dojos WHERE id = ?1", nativeQuery=true)
    Dojo getDojoWhereId_v2(Long id);
    
    // inner join para obtener solo los dojos
    @Query("SELECT d FROM Dojo d JOIN d.ninjas n")
    List<Dojo> joinDojosAndNinjas();
    
    // inner join para obtener los dojos y los ninjas
    @Query("SELECT d, n FROM Dojo d JOIN d.ninjas n")
    List<Object[]> joinDojosAndNinjas2();
    

}
