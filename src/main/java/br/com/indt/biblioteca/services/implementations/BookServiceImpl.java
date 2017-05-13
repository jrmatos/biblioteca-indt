package br.com.indt.biblioteca.services.implementations;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.indt.biblioteca.dao.BookDAO;
import br.com.indt.biblioteca.models.Book;
import br.com.indt.biblioteca.services.BookService;
 

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDAO bookDAO;
        
    // create and persist a new book 
    @Override
    public Book create(Book book) {
    	return bookDAO.save(new Book(book.getName(), book.getAuthor(), book.getPublisher(), book.getYear(), book.getPages(), book.getIsbn()));
    }
    
    // update a book
    @Override
    public Book update(Book book) { 
        return book;
    }
 
 
    // return all books based on a filter
    @Override
    public List<Book> find() {
        return bookDAO.find();
    }
    
 
    // delete book by id
    @Override
    public void delete(String bookId) {
 
    }
         
}