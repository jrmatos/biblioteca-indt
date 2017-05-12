package br.com.indt.biblioteca.services.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import br.com.indt.biblioteca.models.Book;
import br.com.indt.biblioteca.services.BookService;
import br.com.indt.biblioteca.util.HibernateUtil;
 

@Service
public class BookServiceImpl implements BookService {
        
    // create and persist a new book 
    @Override
    public Book create(Book book) {
    	System.out.println("Book...");
    	System.out.println(book);
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	Transaction t = session.beginTransaction();
    	session.save(new Book(1, "O melhor do JavaScript", "Douglas Crockford", "O'Reilly", 2008, 170, 564891223));
    	t.commit();
        return book;
    }
    
    // update a book
    @Override
    public Book update(Book book) {
        return book;
    }
 
 
    // return all books based on a filter
    @Override
    public List<Book> find(Book bookFilter) {
        ArrayList<Book> books = new ArrayList<>();  
        books.add(new Book(1, "O melhor do JavaScript", "Douglas Crockford", "O'Reilly", 2008, 170, 564891223));
        books.add(new Book(2, "PHP. Programando com Orientação a Objetos", "Pablo Dall'Oglio", "Novatec", 2015, 552, 857522));
        return books;
    }
    
 
    // delete book by id
    @Override
    public void delete(String bookId) {
 
    }
         
}