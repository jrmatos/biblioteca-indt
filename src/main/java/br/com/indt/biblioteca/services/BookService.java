package br.com.indt.biblioteca.services;

import java.util.List;

import br.com.indt.biblioteca.models.Book;
import br.com.indt.biblioteca.models.dto.FindBooksResponseDTO;
 
public interface BookService {
     
    Book create(final Book book);
    Book update(Book book);
    FindBooksResponseDTO find(Book bookFilter, Integer page);
    List<Book> findall();
    void delete(final String bookId);
 
}