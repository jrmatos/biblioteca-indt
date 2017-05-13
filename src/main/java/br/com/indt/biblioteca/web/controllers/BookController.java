package br.com.indt.biblioteca.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.indt.biblioteca.models.Book;
import br.com.indt.biblioteca.services.BookService;
 
 
@RestController
//Mapeia as requisições de localhost:8080/book/
@RequestMapping("/book/")
public class BookController {
     
    @Autowired
    private BookService bookService;
     
//    @ResponseStatus(HttpStatus.OK)
//    @RequestMapping(value = "/{bookId}",
//        method = RequestMethod.GET, 
//        produces = MediaType.APPLICATION_JSON_VALUE)
//    public Book get(@PathVariable(value = "bookId") String bookId){
//        return bookService.findById(bookId);
//    }
    
    
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public Book update(@RequestBody Book book){
    	System.out.println("Create => " + book);
        return bookService.create(book);
    }
    
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.PUT,
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public Book create(@RequestBody Book book){    	
        return bookService.update(book);
    }
    
     
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/find",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> find(@RequestParam(value="title", required=false) String title,
				    	   @RequestParam(value="author", required=false) String author,
				    	   @RequestParam(value="publisher", required=false) String publisher,
				    	   @RequestParam(value="year", required=false) Integer year,
				    	   @RequestParam(value="pages", required= false) Integer pages,
				    	   @RequestParam(value="isbn", required=false) Integer isbn,
				    	   @RequestParam(value="page", required=false) Integer page) {
    	
        return bookService.find(new Book(title, author, publisher, year, pages, isbn), page);
    }   
    
    
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{bookId}",
        method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "bookId") String bookId){
        bookService.delete(bookId);
    }
}