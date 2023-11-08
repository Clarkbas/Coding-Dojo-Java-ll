package com.example.MVC.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.MVC.Model.Book;
import com.example.MVC.Services.BookService;


import jakarta.validation.Valid;

//... Sentencias import removidas para resumir
@Controller
public class BooksController {
 private final BookService bookService;
 
 public BooksController(BookService bookService) {
     this.bookService = bookService;
 }
 
 @RequestMapping("/books")
 public String index(Model model) {  //La clase model Sirve para enviar información a la plantilla jsp
     List<Book> books = bookService.allBooks();
     model.addAttribute("books", books); //Con addAttribute Agregamos cosas al model y llegamos al JSP
     return "/books/index.jsp";
 }
 
 @RequestMapping("/books/new")
 public String newBook(@ModelAttribute("book") Book book) {
     return "/books/new.jsp";
 }
 @RequestMapping(value="/books", method=RequestMethod.POST)
 public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
     if (result.hasErrors()) {
         return "/books/new.jsp";
     } else {
         bookService.createBook(book);
         return "redirect:/books";
     }   
 }

 @RequestMapping("/books/{id}")
 public String showBookEditForm(@PathVariable("id") Long id, Model model) {
     Book book = bookService.findBook(id);

     if (book == null) {
         // Redirige a todos los libros si no encuentra el parámetro enviado
         return "redirect:/books";
     }

     model.addAttribute("book", book);
     return "/books/show.jsp";
 }
 
 @RequestMapping("/books/{id}/edit")
 public String edit(@PathVariable("id") Long id, Model model) {
     Book book = bookService.findBook(id);
     model.addAttribute("book", book);
     return "/books/edit.jsp";
 }
 
 @RequestMapping(value="/books/{id}", method=RequestMethod.PUT)
 public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
     if (result.hasErrors()) {
         return "/books/edit.jsp";
     } else {
         bookService.updateBook(book);
         return "redirect:/books";
     }
 }
 @RequestMapping(value="/books/{id}", method=RequestMethod.DELETE)
 public String destroy(@PathVariable("id") Long id) {
     bookService.deleteBook(id);
     return "redirect:/books";
 }

}
