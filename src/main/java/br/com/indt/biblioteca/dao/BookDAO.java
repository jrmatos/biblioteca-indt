package br.com.indt.biblioteca.dao;

import java.util.List;

import br.com.indt.biblioteca.models.Book;

public interface BookDAO {
	public Book save(Book book);
	public List<Book> find();
}
