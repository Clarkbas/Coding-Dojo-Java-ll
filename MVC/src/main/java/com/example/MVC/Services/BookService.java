package com.example.MVC.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.MVC.Model.Book;
import com.example.MVC.repositories.BookRepository;



@Service
public class BookService {
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
    //Devolviendo todos los libros.
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    //Creando un libro.
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    //Obteniendo la información de un libro
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    // primero Cree otro libro, se guardo y luego borre el libro ya creado. Funciono todo :D
    
    public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
	       Book book = bookRepository.findById(id).orElse(null);
	        
	        if (book != null) {
	            // Actualizar los campos del libro con los valores proporcionados
	            book.setTitle(title);
	            book.setDescription(desc);
	            book.setLanguage(lang);
	            book.setNumberOfPages(numOfPages);
	            
	            // Guardar el libro actualizado en la base de datos
	            book = bookRepository.save(book);
	        }
	        
	        return book;
	    }
    
	
	public Book updateBook(Book books) {  
	        return bookRepository.save(books);
	    }
    
	public void deleteBook(Long id) {
     bookRepository.deleteById(id);
     
    
	}

}
