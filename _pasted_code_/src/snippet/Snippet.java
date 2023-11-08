package snippet;

public class Snippet {
	@RequestMapping("/books/{id}/edit")
	public String editBook(@PathVariable("id") Long id, Model model) {
	    Book book = bookService.findBook(id);
	
	    if (book == null) {
	        // Redirige a todos los libros si no encuentra el parámetro enviado
	        return "redirect:/books";
	    }
	
	    model.addAttribute("book", book);
	    return "/books/editBook.jsp";
	}
}

