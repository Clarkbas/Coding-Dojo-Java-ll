package com.example.Lookify.Services;

//importaciones
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.Lookify.Models.Lookify;
import com.example.Lookify.Repositories.LookifyRepository;

@Service
public class LookifyService {
	//Atributos y constructor.
	private final LookifyRepository mR;

	public LookifyService(LookifyRepository mR) {
		this.mR = mR;
	}
	//metodo
	public List<Lookify> allSongs(){
		return mR.findAll();
	}
	//metodo, el cual permite utiliza el metodo save() del repositorio mR para guardarlo en Lookify
	public Lookify addSong(Lookify song) {
		return mR.save(song);
	}
	//metodo, este metodo busca un acnción y verifica si esta en la base de datos y si esta muestra la canción
	public Lookify findSong(Long id) {
		Optional<Lookify> optionalMusic = mR.findById(id);
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
	public void updateSong(Lookify song) {
		mR.save(song);
	}
	//Metodo, devuelve una lista de los top 10 del repositorio mR y de forma descendente.
	public List<Lookify> topTen(){
		return mR.findTop10ByOrderByRatingDesc();
	}
	//Metodo, que busca en la base de datos al dar como parametro el nombre, osea encuentra todas las canciones que el artista tiene
	public List<Lookify> searchBy(String search){
		return mR.findByArtistContainsAllIgnoreCase(search);
	}
}
