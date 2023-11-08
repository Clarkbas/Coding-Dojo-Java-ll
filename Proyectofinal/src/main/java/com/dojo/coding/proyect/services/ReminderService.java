package com.dojo.coding.proyect.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dojo.coding.proyect.models.Reminder;
import com.dojo.coding.proyect.repositories.ReminderRepository;



@Service
public class ReminderService {
	//Atributos y constructor.
	private final ReminderRepository mR;

	public ReminderService(ReminderRepository mR) {
		this.mR = mR;
	}
	//metodo
	public List<Reminder> allSongs(){
		return mR.findAll();
	}
	//metodo, el cual permite utiliza el metodo save() del repositorio mR para guardarlo en Lookify
	public Reminder addSong(Reminder song) {
		return mR.save(song);
	}
	//metodo, este metodo busca un acnción y verifica si esta en la base de datos y si esta muestra la canción
	public Reminder findSong(Long id) {
		Optional<Reminder> optionalMusic = mR.findById(id);
		if(optionalMusic.isPresent()){
			return optionalMusic.get();
		}
		else {
			return null;
		}
	}
	//Metodo, permite eliminar una canción de la base de datos del repositorio mR
	public void deleteSong(Long id) {
		mR.deleteById(id);
	}
	//Metodo, Este método actualiza los datos de una canción existente en la base de datos.
	public void updateSong(Reminder song) {
		mR.save(song);
	}
	//Metodo, devuelve una lista de los top 10 del repositorio mR y de forma descendente.
	public List<Reminder> topTen(){
		return mR.findTop10ByOrderByStartDateDesc();
	}
	//Metodo, que busca en la base de datos al dar como parametro el nombre, osea encuentra todas las canciones que el descriptiona tiene
	public List<Reminder> searchBy(String search){
		return mR.findBydescriptionContainsAllIgnoreCase(search);
	}
}
