package br.com.indt.biblioteca.dao;

import java.util.List;

import br.com.indt.biblioteca.models.Book;

public interface BookDAO {
	public Book save(Book book);
	public Book update(Book book);
	public List<Book> find(Book bookFilter, Integer page, Integer pageSize);
	public List<Book> findall();
	public void delete(String bookId);
	public Integer getBooksQuantity();
	public Integer getBooksQuantityFilter(Book bookFilter);
}
