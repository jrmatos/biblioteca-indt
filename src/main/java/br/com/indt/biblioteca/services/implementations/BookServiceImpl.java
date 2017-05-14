package br.com.indt.biblioteca.services.implementations;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.indt.biblioteca.dao.BookDAO;
import br.com.indt.biblioteca.models.Book;
import br.com.indt.biblioteca.models.dto.FindBooksResponseDTO;
import br.com.indt.biblioteca.services.BookService;
import java.lang.Math;
 

@Service
public class BookServiceImpl implements BookService {
	
	public Integer pageSize = 10;
	
	@Autowired
	private BookDAO bookDAO;
        
    // create and persist a new book 
    @Override
    public Book create(Book book) {
    	return bookDAO.save(new Book(book.getTitle(), book.getAuthor(), book.getPublisher(), book.getYear(), book.getPages(), book.getIsbn()));
    }
    
    // update a book
    @Override
    public Book update(Book book) { 
        return bookDAO.update(book);
    }
 
    // return all books
    @Override
    public FindBooksResponseDTO find(Book bookFilter, Integer page) {
    	Integer totalBooks = 0;
    	
    	//  if it's not fintering, then totalBooks is equal to all books
    	if(!isFiltering(bookFilter)) {
    		totalBooks = bookDAO.getBooksQuantity();
    	}
    	// if it's filtering, then totalBooks is equal to the amount of books using the filter
    	else {
    		totalBooks = bookDAO.getBooksQuantityFilter(bookFilter);
    	}

    	return new FindBooksResponseDTO(
    			bookDAO.find(bookFilter, page, pageSize),
    			(page != null) ? page: 1,
            	pageSize,
            	totalBooks
    	);
    }
    
    private Boolean isFiltering(Book bookFilter) {
    	return (bookFilter.getTitle() != null ||
    			bookFilter.getAuthor() != null ||
    			bookFilter.getPublisher() != null ||
    			bookFilter.getYear() != null ||
    			bookFilter.getPages() != null ||
    			bookFilter.getIsbn() != null);
    }
    
    // delete book by id
    @Override
    public void delete(String bookId) {
    	bookDAO.delete(bookId);
    }

	@Override
	public List<Book> findall() {
		return bookDAO.findall();
	}

}