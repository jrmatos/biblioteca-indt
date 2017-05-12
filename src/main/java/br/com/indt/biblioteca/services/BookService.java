package br.com.indt.biblioteca.services;

import java.util.List;

import br.com.indt.biblioteca.models.Book;
 
public interface BookService {
     
    Book create(final Book book);
    Book update(Book book);
    List<Book> find(Book book);    
    void delete(final String bookId);
 
}